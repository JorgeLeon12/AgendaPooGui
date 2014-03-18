import javax.swing.*;
//import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
public class Principal extends JFrame implements ActionListener{

	private Agenda datos;
	private JButton opc1, opc2, opc3, opc4, regresar, enviarBusc, enviarCont, bContBoton;
	private JTextField buscar, nombre, apellidos, categoria, correo, telefono, celular, direccion, nota, bCont;
	public JPanel panelBoton;
	private JLabel txtnombre, txtapellidos, txtcategoria, txtcorreo, txttelefono, txtcelular, txtdireccion, txtnota, bText;
	
	private Principal(){
		super("Agenda");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.opc1 = new JButton("Agregar Contacto");
		this.opc2 = new JButton("Buscar Contacto");
		this.opc3 = new JButton("Borrar Contacto");
		this.opc4 = new JButton("Salir");
		this.nombre = new JTextField();


		//FlowLayout fl = new FlowLayout();
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(null);


		this.opc1.addActionListener(this);
		this.opc2.addActionListener(this);
		this.opc3.addActionListener(this);
		this.opc4.addActionListener(this);

		this.opc1.setBounds(125, 80, 250 , 30);
		this.opc2.setBounds(125, 160, 250 , 30);
		this.opc3.setBounds(125, 240, 250 , 30);
		this.opc4.setBounds(125, 320, 250 , 30);
		panelBoton.add(this.opc1);
		panelBoton.add(this.opc2);
		panelBoton.add(this.opc3);
		panelBoton.add(this.opc4);
		
		//----------------------------------------------------------  buscarCon
		buscar = new JTextField(25);
		enviarBusc = new JButton("Buscar!");
		regresar = new JButton("<--");

		enviarBusc.addActionListener(this);
		regresar.addActionListener(this);

		buscar.setBounds(125, 80, 250, 30);
		enviarBusc.setBounds(125, 160, 250 , 30);
		regresar.setBounds(5, 5, 50, 30);

		panelBoton.add(buscar);
		panelBoton.add(enviarBusc);
		panelBoton.add(regresar);

		buscar.setVisible(false);
		enviarBusc.setVisible(false);
		regresar.setVisible(false);
		//----------------------------------------------------------  /buscarCon


		//----------------------------------------------------------  pideContacto
		nombre = new JTextField(25);
		apellidos = new JTextField(25);
		categoria = new JTextField(25);
		correo = new JTextField(25);
		telefono = new JTextField(25);
		celular = new JTextField(25);
		direccion = new JTextField(25);
		nota = new JTextField(25);
		enviarCont = new JButton("Agregar Contacto!");

		txtnombre = new JLabel("Nombre");
		txtapellidos = new JLabel("Apellidos");
		txtcategoria = new JLabel("Categoria");
		txtcorreo = new JLabel("Correo");
		txttelefono = new JLabel("Telefono");
		txtcelular = new JLabel("Celular");
		txtdireccion = new JLabel("Direccion");
		txtnota = new JLabel("Nota");

		Font myFont= new Font ("Comic Sans MS", 1, 20);
		txtnombre.setFont(myFont);
		txtapellidos.setFont(myFont);
		txtcategoria.setFont(myFont);
		txtcorreo.setFont(myFont);
		txttelefono.setFont(myFont);
		txtcelular.setFont(myFont);
		txtdireccion.setFont(myFont);
		txtnota.setFont(myFont);
		

		nombre.addActionListener(this);
		apellidos.addActionListener(this);
		categoria.addActionListener(this);
		correo.addActionListener(this);
		telefono.addActionListener(this);
		celular.addActionListener(this);
		direccion.addActionListener(this);
		nota.addActionListener(this);
		enviarCont.addActionListener(this);

		nombre.setBounds(180, 10 , 250, 30);
		apellidos.setBounds(180, 60 , 250, 30);
		categoria.setBounds(180, 110 , 250, 30);
		correo.setBounds(180, 160 , 250, 30);
		telefono.setBounds(180, 210 , 250, 30);
		celular.setBounds(180, 260 , 250, 30);
		direccion.setBounds(180, 310 , 250, 30);
		nota.setBounds(180, 360 , 250, 30);
		enviarCont.setBounds(125, 410, 250 , 30);
		
		txtnombre.setBounds(80, 0, 500, 50);
		txtapellidos.setBounds(80, 50, 500, 50);
		txtcategoria.setBounds(80, 100, 500, 50);
		txtcorreo.setBounds(80, 150, 500, 50);
		txttelefono.setBounds(80, 200, 500, 50);
		txtcelular.setBounds(80, 250, 500, 50);
		txtdireccion.setBounds(80, 300, 500, 50);
		txtnota.setBounds(80, 350, 500, 50);

		panelBoton.add(nombre);
		panelBoton.add(apellidos);
		panelBoton.add(categoria);
		panelBoton.add(correo);
		panelBoton.add(telefono);
		panelBoton.add(celular);
		panelBoton.add(direccion);
		panelBoton.add(nota);
		panelBoton.add(enviarCont);

		panelBoton.add(txtnombre);
		panelBoton.add(txtapellidos);
		panelBoton.add(txtcategoria);
		panelBoton.add(txtcorreo);
		panelBoton.add(txttelefono);
		panelBoton.add(txtcelular);
		panelBoton.add(txtdireccion);
		panelBoton.add(txtnota);


		nombre.setVisible(false);
		apellidos.setVisible(false);
		categoria.setVisible(false);
		correo.setVisible(false);
		telefono.setVisible(false);
		celular.setVisible(false);
		direccion.setVisible(false);
		nota.setVisible(false);
		enviarCont.setVisible(false);

		txtnombre.setVisible(false);
		txtapellidos.setVisible(false);
		txtcategoria.setVisible(false);
		txtcorreo.setVisible(false);
		txttelefono.setVisible(false);
		txtcelular.setVisible(false);
		txtdireccion.setVisible(false);
		txtnota.setVisible(false);
		//----------------------------------------------------------  /pideContacto

		//----------------------------------------------------------  BorrarContacto
		bCont = new JTextField(25);
		bContBoton = new JButton("Agregar Contacto!");
		bText = new JLabel("Posicion a eliminar");

		bText.setFont(myFont);

		bContBoton.addActionListener(this);
		
		//
		bText.setBounds(100, 50, 500, 50);
		bCont.setBounds(290, 60, 100 , 30);
		bContBoton.setBounds(125, 120, 250 , 30);
		//

		panelBoton.add(bContBoton);
		panelBoton.add(bText);
		panelBoton.add(bCont);
		
		bContBoton.setVisible(false);
		bText.setVisible(false);
		bCont.setVisible(false);
		//----------------------------------------------------------  /BorrarContacto

		this.add(panelBoton);
		
		this.setVisible(true);
		this.datos = new Agenda();
	}
	
	private void imprimeMenu(){
		opc1.setVisible(true);
		opc2.setVisible(true);
		opc3.setVisible(true);
		opc4.setVisible(true);

		regresar.setVisible(false);
	}

	private void pideContacto(){
		nombre.setVisible(true);
		apellidos.setVisible(true);
		categoria.setVisible(true);
		correo.setVisible(true);
		telefono.setVisible(true);
		celular.setVisible(true);
		direccion.setVisible(true);
		nota.setVisible(true);
		enviarCont.setVisible(true);

		txtnombre.setVisible(true);
		txtapellidos.setVisible(true);
		txtcategoria.setVisible(true);
		txtcorreo.setVisible(true);
		txttelefono.setVisible(true);
		txtcelular.setVisible(true);
		txtdireccion.setVisible(true);
		txtnota.setVisible(true);
		/*
		String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre:");
		String apellidos = JOptionPane.showInputDialog(null, "Introduce los apellidos:");
		String categoria = JOptionPane.showInputDialog(null, "Introduce la categoria:");
		String correo = JOptionPane.showInputDialog(null, "Introduce el correo:");
		String telefono = JOptionPane.showInputDialog(null, "Introduce el telefono:");
		String celular = JOptionPane.showInputDialog(null, "Introduce el celular:");
		String direccion = JOptionPane.showInputDialog(null, "Introduce la direccion:");
		String nota = JOptionPane.showInputDialog(null, "Introduce la nota:");
		Contacto temporal = new Contacto(nombre, apellidos, categoria, correo, telefono, celular, direccion, nota);*/
		//return temporal;
	}

	/*private Contacto creContacto(){
		Contacto temporal = new Contacto(txtnombre, txtapellidos, txtcategoria, txtcorreo, txttelefono, txtcelular, txtdireccion, txtnota);
		return temporal;
	}*/

	public static void main(String[] args){
		Principal agendita = new Principal();
		System.out.println("////////////////////////////////////////");
		System.out.println("///     Jorge Enrique Moreno León    ///");
		System.out.println("///             A01226804            ///");
		System.out.println("///                                  ///");
		System.out.println("/// Programacion Orientada a Objetos ///");
		System.out.println("////////////////////////////////////////");
		System.out.println();
		//agendita.imprimeMenu();
	}

	private void ocultarOpc(){
		opc1.setVisible(false);
		opc2.setVisible(false);
		opc3.setVisible(false);
		opc4.setVisible(false);
	}

	private void ocultaTodo(){
		buscar.setVisible(false);
		enviarBusc.setVisible(false);
		regresar.setVisible(false);
		nombre.setVisible(false);
		apellidos.setVisible(false);
		categoria.setVisible(false);
		correo.setVisible(false);
		telefono.setVisible(false);
		celular.setVisible(false);
		direccion.setVisible(false);
		nota.setVisible(false);
		enviarCont.setVisible(false);
		txtnombre.setVisible(false);
		txtapellidos.setVisible(false);
		txtcategoria.setVisible(false);
		txtcorreo.setVisible(false);
		txttelefono.setVisible(false);
		txtcelular.setVisible(false);
		txtdireccion.setVisible(false);
		txtnota.setVisible(false);
		bContBoton.setVisible(false);
		bText.setVisible(false);
		bCont.setVisible(false);
	}

	private void buscarCon(){
		/*
		JPanel panel=new JPanel();

		buscar = new JTextField(25);
		enviarBusc = new JButton("Buscar!");
		regresar = new JButton("Regresar!");

		enviarBusc.addActionListener(this);
		regresar.addActionListener(this);

		buscar.setBounds(125, 250, 200, 30);
		enviarBusc.setBounds(125, 300, 250 , 30);
		regresar.setBounds(125, 400, 300, 30);

		panel.add(buscar);
		panel.add(enviarBusc);
		panel.add(regresar);

		add(panel, BorderLayout.CENTER);*/
		buscar.setVisible(true);
		enviarBusc.setVisible(true);

		//String buscar = JOptionPane.showInputDialog(null, "Texto a buscar en la agenda:");
		//this.datos.buscarContacto(buscar);

	}

	private void eliminarContacto(){
		bContBoton.setVisible(true);
		bText.setVisible(true);
		bCont.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		ocultarOpc();
		
		if(e.getSource() == opc1){
			//datos.agregarContacto(this.pideContacto());
			regresar.setVisible(true);
			pideContacto();
			//imprimeMenu();
		}else if(e.getSource() == opc2){
			regresar.setVisible(true);
			buscarCon();
		}else if(e.getSource() == opc3){
			regresar.setVisible(true);
			eliminarContacto();
			/*borrar = Integer.parseInt(JOptionPane.showInputDialog(null, "Posicion del contacto a eliminar:"));
			this.datos.borrarContacto(borrar);*/
		}else if(e.getSource() == opc4){
			System.exit(0);
		}

		else if(e.getSource() == enviarBusc){
			this.datos.buscarContacto(buscar.getText());

			ocultaTodo();
			imprimeMenu();
		}else if(e.getSource() == regresar){
			ocultaTodo();
			imprimeMenu();
		}else if(e.getSource() == enviarCont){
			Contacto temporal = new Contacto(nombre.getText(), apellidos.getText(), categoria.getText(), correo.getText(), telefono.getText(), celular.getText(), direccion.getText(), nota.getText());
			datos.agregarContacto(temporal);
			ocultaTodo();
			imprimeMenu();
			//Contacto temporal = new Contacto(nombre, apellidos, categoria, correo, telefono, celular, direccion, nota);
		}else if(e.getSource() == bContBoton){
			this.datos.borrarContacto((Integer.parseInt(bCont.getText())));
			ocultaTodo();
			imprimeMenu();
		}
		buscar.setText("");
		nombre.setText("");
		apellidos.setText("");
		categoria.setText("");
		correo.setText("");
		telefono.setText("");
		celular.setText("");
		direccion.setText("");
		nota.setText("");
		repaint();
	}
}