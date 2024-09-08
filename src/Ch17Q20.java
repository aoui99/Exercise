import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class Ch17Q20 extends JFrame implements KeyListener{
    private JTextField textField;
    private FileDialog fd;
    private JTextArea binaryTextArea;
    private String filename;
    public Ch17Q20() {
        // 设置窗口标题
        setTitle("Ch17Q20");
        // 设置窗口大小
        setSize(500, 300);
        // 设置窗口关闭按钮操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建一个面板
        JPanel panel = new JPanel();

        JLabel lname = new JLabel("Enter a file:");
        // 创建文本域
        textField = new JTextField(30);
        // 设置回车键监听器
        textField.addActionListener(new EnterKeyListener());

        // 创建文本区域
        binaryTextArea = new JTextArea(10,40);
        binaryTextArea.addKeyListener(this);
        binaryTextArea.setEditable(true);
        binaryTextArea.setLineWrap(true);
        binaryTextArea.setCaretPosition(0);

        // 创建滚动面板并将文本区域添加到其中
        JScrollPane scrollPane = new JScrollPane(binaryTextArea);

        // 创建Open按钮
        JButton openButton = new JButton("Open");
        openButton.addActionListener(new OpenButtonListener());


        // 创建Open按钮
        JButton saveButton = new JButton("Save the change");
        saveButton.addActionListener(new SaveButtonListener());

        // 将文本域添加到面板
        panel.add(lname);
        panel.add(textField);
        panel.add(openButton,BorderLayout.SOUTH);
        panel.add(scrollPane,BorderLayout.CENTER);
        panel.add(saveButton,BorderLayout.SOUTH);


        // 将面板添加到窗口
        add(panel);

        // 显示窗口
        setVisible(true);
    }

    // 回车键监听器
    private class EnterKeyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fileName = textField.getText();
            filename = fileName;
            File file = new File(fileName);

            // 在这里执行相应的操作，例如读取文件或执行某些操作
            System.out.println("File name: " + fileName);
            if(file.exists()){
                try {
                    byte[] fileByte = readBytesFromFile(file);
                    String binaryString = convertBytesToBinaryString(fileByte);
                    binaryTextArea.setText(binaryString);
                    //BitOutputStream bos = new BitOutputStream(new FileOutputStream(fileName));


                }catch (IOException ex){
                    binaryTextArea.setText("Error reading file: " + ex.getMessage());
                };
            } else {
                binaryTextArea.setText("File not found: " + fileName);
            }

            // 清空文本域
            //textField.setText("");
        }
    }

    // Open按钮监听器
    private class OpenButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    // Save按钮监听器
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                BitOutputStream bos = new BitOutputStream(new FileOutputStream(filename));

                bos.writeBit(binaryTextArea.getText());

                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private byte[] readBytesFromFile(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return outputStream.toByteArray();
        }
    }

    // 将字节数组转换为二进制字符串
    private String convertBytesToBinaryString(byte[] bytes) {
        StringBuilder binaryString = new StringBuilder();

        for (byte b : bytes) {
            for (int i = 7; i >= 0; i--) {
                binaryString.append((b >> i) & 1);
            }

            //binaryString.append(" ");
        }

        return binaryString.toString();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c != '0' && c != '1'){
            throw new IllegalArgumentException("Invalid bit: " + c);
        }
        e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ch17Q20();
            }
        });
    }
}
