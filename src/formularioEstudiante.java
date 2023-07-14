import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class formularioEstudiante {
    private JPanel rootPanel;
    private JLabel estudiante_label;
    private JLabel codigo_label;
    private JLabel cedula_label;
    private JLabel nombre_label;
    private JLabel apellido_label;
    private JLabel signo_label;
    private JTextField codigo_in;
    private JTextField cedula_in;
    private JTextField nombre_in;
    private JTextField apellido_in;
    private JLabel fechaNac_label;
    private JLabel color_label;
    private JLabel casado_label;
    private JCheckBox rojo_select;
    private JCheckBox verde_select;
    private JCheckBox ninguno_select;
    private JRadioButton si_select;
    private JRadioButton no_select;
    private JComboBox signo_select;
    private JComboBox anio_select;
    private JComboBox mes_select;
    private JComboBox dia_select;
    private JButton guardarButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton cargarButton;

    private int items=0;
    String filepath = "datos.dat";

    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public formularioEstudiante() {
        signo_select.addItem("Aries");
        signo_select.addItem("Tauro");
        signo_select.addItem("Géminis");
        signo_select.addItem("Cáncer");
        signo_select.addItem("Leo");
        signo_select.addItem("Virgo");

        anio_select.addItem(2001);
        anio_select.addItem(2002);
        anio_select.addItem(2003);
        anio_select.addItem(2004);
        anio_select.addItem(2005);

        mes_select.addItem("Enero");
        mes_select.addItem("Febrero");
        mes_select.addItem("Marzo");
        mes_select.addItem("Abril");
        mes_select.addItem("Mayo");

        dia_select.addItem(01);
        dia_select.addItem(02);
        dia_select.addItem(03);
        dia_select.addItem(04);
        dia_select.addItem(05);


            guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //objeto definido
                Estudiante nuevoEstudiante = new Estudiante(codigo_in.getText(), cedula_in.getText(), nombre_in.getText(), apellido_in.getText());

                //bucle de ingreso de datos
                for (int i = 0; i <= items; i++) {
                    estudiantes.add(nuevoEstudiante);
                }

                //guardar datos
                try (
                        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                    for (int i = 0; i < estudiantes.size(); i++) {
                        if (estudiantes.get(i++).equals(estudiantes.get(i - 1))) break;
                        else {
                            objectOutputStream.writeObject(estudiantes.get(i).getCodigo());
                            objectOutputStream.writeObject(estudiantes.get(i).getCedula());
                            objectOutputStream.writeObject(estudiantes.get(i).getNombre());
                            objectOutputStream.writeObject(estudiantes.get(i).getApellido());

                            System.out.println("Archivo escrito correctamente");
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        FileInputStream fileInputStream = new FileInputStream(filepath);
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
                {
                    Estudiante readObject = (Estudiante) objectInputStream.readObject();
                    System.out.println("El archivo en disco es: "+readObject);

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo_in.setText(null);
                cedula_in.setText(null);
                nombre_in.setText(null);
                apellido_in.setText(null);

                for(Estudiante estudiante: estudiantes){
                    codigo_in.setText(estudiante.getCodigo());
                    cedula_in.setText(estudiante.getCedula());
                    nombre_in.setText(estudiante.getNombre());
                    apellido_in.setText(estudiante.getApellido());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formularioEstudiante");
        frame.setContentPane(new formularioEstudiante().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
