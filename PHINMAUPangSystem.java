import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;

public class PHINMAUPangSystem {
    public static void main(String[] args) {


        //SCHOLARSHIPS
        ArrayList<String> scholarships = new ArrayList<>();
        scholarships.add("PHINMA Scholarship (formerly Presidential Scholarship)");
        scholarships.add("Student Assistance Scholarship");
        scholarships.add("Valedictorian & Salutatorian Scholarship");
        scholarships.add("Dean's List Scholarship");
        scholarships.add("With Highest Honor");
        scholarships.add("PHINMA UPang Direct Dependent Scholarship");
        scholarships.add("Hawak Kamay Scholarship");
        scholarships.add("Victory Liner, 5-Star, and Transasia Oil Employee & Direct Dependent Scholarship");
        scholarships.add("The Medical City Employee & Direct Dependent Scholarship");
        scholarships.add("Kapamilya @ PHINMA UPang Scholarship");
        scholarships.add("PHINMA UPang Alumni Scholarship");


        // Create a new frame
        JFrame frame = new JFrame("PHINMA UPang Information System");

        // Set frame size to 600x600
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout for the frame
        frame.setLayout(new BorderLayout());

        // Create the label at the top and panel for padding
        JLabel label = new JLabel("PHINMA UPang Information System", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(label, BorderLayout.NORTH);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 20)); // 3 rows, 1 column, 10px spacing

        // Create buttons and set their preferred sizes
        JButton scholarshipsB = new JButton("Scholarships");
        JButton coursesB = new JButton("Courses");
        JButton deansB = new JButton("Deans");

        // Button Dimension
        Dimension buttonSize = new Dimension(200,50);

        // Set to Buttons
        scholarshipsB.setPreferredSize(buttonSize);

        // Add buttons to the panel
        buttonPanel.add(scholarshipsB);
        buttonPanel.add(coursesB);
        buttonPanel.add(deansB);

        // Add button panel padding on top
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));

        // Add the button panel to the center of the frame
        JPanel wrapperPanel = new JPanel(); // Wrapper panel for centering the buttons
        wrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Center alignment
        wrapperPanel.add(buttonPanel);

        // Make label for what account is used
        JLabel account_identify = new JLabel();
        account_identify.setText("Logged in as " + "Student." + " Are you an admin?");

        // Make login or sign out button
        JButton acc_entry = new JButton("Log in");

        // Make footer panel
        JPanel footer = new JPanel();
        footer.add(account_identify);
        footer.add(acc_entry);


        scholarshipsB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                JFrame scholar_frame = new JFrame();
                scholar_frame.setLayout(new BorderLayout());
                scholar_frame.setSize(600,600);
                scholar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel scholar_buttons = new JPanel();
                scholar_buttons.setLayout(new GridLayout(0, 1, 10, 20));
                scholar_buttons.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

                for (String scholarship : scholarships) {
                JButton button = new JButton(scholarship);
                scholar_buttons.add(button);
                }

                JButton back = new JButton("Go Back");
                scholar_buttons.add(back);


                JPanel center_scholar = new JPanel();
                center_scholar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                center_scholar.add(scholar_buttons);

                scholar_frame.add(center_scholar);
                scholar_frame.setVisible(true);


                back.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e){

                     scholar_frame.dispose();
                     frame.setVisible(true);

                 }


                });

                // Create input field and button to add new scholarships
                JPanel inputPanel = new JPanel();
                inputPanel.setLayout(new FlowLayout()); // Use FlowLayout for side-by-side arrangement
                JTextField inputField = new JTextField(20);
                JButton addButton = new JButton("Add Scholarship");
                JButton backButton = new JButton("Go Back"); // New back button

                inputPanel.add(inputField);
                inputPanel.add(addButton);
                inputPanel.add(backButton); // Add the new back button
                scholar_frame.add(inputPanel, BorderLayout.SOUTH);

                // Action listener for adding new scholarships
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newScholarship = inputField.getText();
                        if (!newScholarship.isEmpty()) {
                            scholarships.add(newScholarship);
                            JButton newButton = new JButton(newScholarship);
                            scholar_buttons.add(newButton);

                            inputField.setText(""); // Clear input field
                            scholar_frame.revalidate(); // Revalidate the frame to update the layout
                        }
                    }
                });

                // Action listener for the new back button
                backButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        scholar_frame.dispose();
                        frame.setVisible(true);
                    }
                });


            }
        });



        frame.add(wrapperPanel, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);

        // Make login button

        acc_entry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = new JFrame("Login Frame");
                loginFrame.setSize(300, 200);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create a panel for login fields
                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(3, 2, 5, 5)); // 3 rows, 2 columns, spacing

                // Create components for username, password, and button
                JLabel usernameLabel = new JLabel("Username:");
                JTextField usernameField = new JTextField();
                JLabel passwordLabel = new JLabel("Password:");
                JPasswordField passwordField = new JPasswordField();
                JButton loginButton = new JButton("Login");

                // Add components to the panel
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);
                loginPanel.add(new JLabel()); // Empty cell for layout
                loginPanel.add(loginButton);

                // Add the panel to the login frame
                loginFrame.add(loginPanel);
                loginFrame.setVisible(true);

                                loginButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the input from the username and password fields
                                        String username = usernameField.getText();
                                        String password = new String(passwordField.getPassword());

                                        // Check if the input is "admin"
                                        if (username.equals("admin") && password.equals("admin")) {
                                            // Dispose of the login frame
                                            loginFrame.dispose();
                                            frame.setVisible(false);

                                            // Create the new frame
                                            JFrame adminFrame = new JFrame("Welcome, Admin!");
                                            adminFrame.setSize(600, 600);
                                            adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            adminFrame.setLayout(new BorderLayout());

                                            //scholar frame (again)

                                            frame.setVisible(false);
                                            JFrame scholar_frame = new JFrame();
                                            scholar_frame.setLayout(new BorderLayout());
                                            scholar_frame.setSize(600,600);
                                            scholar_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                                            JPanel scholar_buttons = new JPanel();
                                            scholar_buttons.setLayout(new GridLayout(0, 1, 10, 20));
                                            scholar_buttons.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

                                            for (String scholarship : scholarships) {
                                            JButton button = new JButton(scholarship);
                                            scholar_buttons.add(button);
                                            }


                                            JButton back = new JButton("Go Back");
                                            scholar_buttons.add(back);

                                            JPanel center_scholar = new JPanel();
                                            center_scholar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                                            center_scholar.add(scholar_buttons);

                                            scholar_frame.add(center_scholar);


                                            back.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e){

                                                scholar_frame.dispose();
                                                adminFrame.setVisible(true);

                                            }


                                            });


                                            // Add a welcome message to the new frame
                                            // Create the label at the top and panel for padding
                                            JLabel label = new JLabel("PHINMA UPang Information System", SwingConstants.CENTER);
                                            label.setFont(new Font("Arial", Font.BOLD, 20));
                                            adminFrame.add(label, BorderLayout.NORTH);

                                            // Create a panel for buttons
                                            JPanel buttonPanel = new JPanel();
                                            buttonPanel.setLayout(new GridLayout(3, 1, 10, 20)); // 3 rows, 1 column, 10px spacing

                                            // Create buttons and set their preferred sizes
                                            JButton add_scholarshipsB = new JButton("Manage Scholarships");
                                            JButton add_coursesB = new JButton("Manage Courses");
                                            JButton add_deansB = new JButton("Manage Deans");

                                            // Button Dimension
                                            Dimension buttonSize = new Dimension(200,50);

                                            // Set to Buttons (it sets to all buttons)
                                            add_scholarshipsB.setPreferredSize(buttonSize);

                                            // Add buttons to the panel
                                            buttonPanel.add(add_scholarshipsB);
                                            buttonPanel.add(add_coursesB);
                                            buttonPanel.add(add_deansB);

                                            // Add button panel padding on top
                                            buttonPanel.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));

                                            // Add the button panel to the center of the frame
                                            JPanel wrapperPanel = new JPanel(); // Wrapper panel for centering the buttons
                                            wrapperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Center alignment
                                            wrapperPanel.add(buttonPanel);

                                            // Make label for what account is used
                                            JLabel account_identify = new JLabel();
                                            account_identify.setText("Logged in as " + "Admin." + " Not an admin?");

                                            // Make login or sign out button
                                            JButton admin_acc_entry = new JButton("Log out");

                                            // Make footer panel
                                            JPanel footer = new JPanel();
                                            footer.add(account_identify);
                                            footer.add(admin_acc_entry);


                                            adminFrame.add(wrapperPanel, BorderLayout.CENTER);
                                            adminFrame.add(footer, BorderLayout.SOUTH);

                                            adminFrame.setVisible(true);

                                            // Log out function
                                            admin_acc_entry.addActionListener(new ActionListener(){
                                                @Override
                                                public void actionPerformed(ActionEvent e){

                                                    adminFrame.setVisible(false);
                                                    frame.setVisible(true);

                                                }
                                            });

                                            // Add scholar function
                                            add_scholarshipsB.addActionListener(new ActionListener(){
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                adminFrame.setVisible(false);
                                                scholar_frame.setVisible(true);
                                            }
                                            });



                                            scholar_frame.setVisible(true);


                                        } else {
                                            // Show error message if credentials are incorrect
                                            JOptionPane.showMessageDialog(loginFrame, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                });



                }

                });




    }
}