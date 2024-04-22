package prog.unidad05.gui.ejercicio08;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class EstadisticasSwingApp {

  private JFrame frame;
  private JTextField txtCantidad;
  private JTextField txtMinimo;
  private JTextField txtMaximo;
  private JLabel lblListaGenerada;
  private JList<Integer> lstPrincipal;
  private JLabel lblMedia;
  private JScrollPane scrollPane_1;
  private JScrollPane scrollPane_2;
  private JList<Integer> lstMenor;
  private JList<Integer> lstMayor;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          EstadisticasSwingApp window = new EstadisticasSwingApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public EstadisticasSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 550, 510);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblCantidadDeNmeros = new JLabel("Cantidad de números a generar (mínimo 3):");
    
    txtCantidad = new JTextField();
    txtCantidad.setColumns(10);
    
    JLabel lblValorM = new JLabel("Valor mínimo de los números a generar:");
    
    txtMinimo = new JTextField();
    txtMinimo.setColumns(10);
    
    JLabel lblValorMximoDe = new JLabel("Valor máximo de los números a generar:");
    
    txtMaximo = new JTextField();
    txtMaximo.setColumns(10);
    
    JButton btnGenerar = new JButton("Generar");
    btnGenerar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Lanza el procesamiento al pulsar el botón
        lanzarProceso();
      }
    });
    
    lblListaGenerada = new JLabel("Lista Generada:");
    
    JScrollPane scrollPane = new JScrollPane();
    
    lblMedia = new JLabel("   ");
    
    scrollPane_1 = new JScrollPane();
    
    scrollPane_2 = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblCantidadDeNmeros)
                .addComponent(lblValorM)
                .addComponent(lblValorMximoDe))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(txtMaximo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createSequentialGroup()
                  .addComponent(txtMinimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addGap(18)
                  .addComponent(btnGenerar))
                .addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addComponent(lblListaGenerada)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblMedia)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblCantidadDeNmeros))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblValorM)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
              .addComponent(txtMinimo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addComponent(btnGenerar)))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblValorMximoDe)
            .addComponent(txtMaximo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addComponent(lblListaGenerada)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblMedia)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
            .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    
    lstMayor = new JList<>();
    scrollPane_2.setViewportView(lstMayor);
    
    lstMenor = new JList<>();
    scrollPane_1.setViewportView(lstMenor);
    
    lstPrincipal = new JList<>();
    scrollPane.setViewportView(lstPrincipal);
    frame.getContentPane().setLayout(groupLayout);
  }

  /**
   * Lanza el proceso de rellenar las listas
   */
  protected void lanzarProceso() {
    // Obtiene la cantidad de números, el mínimo y el máximo
    int cantidad;
    try {
      cantidad = Integer.parseInt(txtCantidad.getText());
    } catch (NumberFormatException e) {
      // Valor erróneo
      JOptionPane.showMessageDialog(null, "La cantidad de valores no es un número");
      return;
    }
    // Si la cantidad es menor de 3 lanza un error y termina
    if (cantidad < 3) {
      JOptionPane.showMessageDialog(null, "La cantidad de valores debe ser mayor que 3");
      return;
    }
    
    // Ahora procesamos el valor mínimo
    int valorMinimo;
    try {
      valorMinimo = Integer.parseInt(txtMinimo.getText());
    } catch (NumberFormatException e) {
      // Valor minimo invalido
      // Mensaje y terminamos
      JOptionPane.showMessageDialog(null, "El valor del mínimo no es válido");
      return;
    }

    // Por último procesamos el máximo
    int valorMaximo;
    try {
      valorMaximo = Integer.parseInt(txtMaximo.getText());
    } catch (NumberFormatException e) {
      // Valor maximo invalido
      // Mensaje y terminamos
      JOptionPane.showMessageDialog(null, "El valor del máximo no es válido");
      return;
    }

    // El valor máximo debe ser mayor que el mínimo
    if (valorMaximo <= valorMinimo) {
      JOptionPane.showMessageDialog(null, "El valor mínimo debe ser menor que el máximo");
      return;
    }
    
    // Creamos el modelo para la lista principal
    DefaultListModel<Integer> modeloPrincipal = new DefaultListModel<>();
    // Suma para la media
    double suma = 0;
    // Generador de números aleatorios
    Random random = new Random();
    // Para la cantidad de numeros solicitada
    for (int i = 0; i < cantidad; i++) {
      // Generamos el número y lo insertamos en la lista
      int valor = random.nextInt(valorMinimo, valorMaximo + 1);
      modeloPrincipal.addElement(valor);
      // Y lo sumamos para la media
      suma += valor;
    }
    // Y se lo asignamos
    lstPrincipal.setModel(modeloPrincipal);
    
    // Calculamos la media
    double media = suma / cantidad;
    // Y la mostramos
    lblMedia.setText("La media vale " + String.format("%f", media));
    
    // Ahora rellenamos las dos listas con los menores y los mayores que la media
    DefaultListModel<Integer> modeloMenor = new DefaultListModel<>();
    DefaultListModel<Integer> modeloMayor = new DefaultListModel<>();
    // Recorremos el modelo principal
    for (int i = 0; i < modeloPrincipal.size(); i++) {
      // Obtiene el valor
      int valor = modeloPrincipal.get(i); 
      // Si el valor es superior o igual a la media
      if (valor >= media) {
        // Va al modelo mayor
        modeloMayor.addElement(valor);
      } else {
        // Va al modelo menor
        modeloMenor.addElement(valor);
      }
    }
    
    // Asigna los modelos a las listas
    lstMenor.setModel(modeloMenor);
    lstMayor.setModel(modeloMayor);
  }
}