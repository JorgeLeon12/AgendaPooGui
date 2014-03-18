import javax.swing.table.*;
import java.util.*;

import javax.swing.*;
//import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Agenda{
	private Contacto[] contactos;
	private int numContactos;

	public Agenda(){
		this.contactos = new Contacto[10];
		for(int i = 0; i < 10; i++){
			this.contactos[i] = new Contacto("","","","","","","","");
		}
		this.numContactos = 0;
	}

	public Agenda(int cantidad){
		Contacto[] contactos = new Contacto[cantidad];
		for(int i = 0; i < cantidad; i++){	
			this.contactos[i] = new Contacto("","","","","","","","");
		}
		this.numContactos = 0;
	}

	public void agregarContacto(Contacto datos){
		int res;
		String ultimo = "false";

		if((this.numContactos) < this.contactos.length){//ve si cabe el nuevo contacto
			int i;
			parseo:for(i = 0; i<=this.numContactos;i++){//parsea el arreglo
				if((this.contactos[i].getApellidos().equals(datos.getApellidos())) == false){//ve que los apellidos sean diferentes
					if(this.contactos[i].getApellidos().compareTo(datos.getApellidos()) < 0){//ve si el apellido nuevo es igual al que esta parseando en el momento
						ultimo = "true";
					}else{
						ultimo = "false";
						break parseo;
					}
				}else{//los apellidos son iguales
					for(i = i; i <= this.numContactos && this.contactos[i].getApellidos().equals(datos.getApellidos());i++){
						if(this.contactos[i].getNombre().compareTo(datos.getNombre()) < 0){//ve si el nombre nuevo es igual al que esta parseando en el momento
							ultimo = "true nom";
						}else{
							ultimo = "false";
							break parseo;
						}
					}
					break parseo;
				}
			}
			if(ultimo == "true"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else if(ultimo == "true nom"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else{
				this.recorrerDatosPosi(i);
				this.contactos[i] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.	getDireccion(), datos.getNota()) ;
			}
			this.numContactos++;
		}else{
			JOptionPane.showMessageDialog(null, "Agenda llena, expandiendo la agenda...");
			this.aumentarObjeto();
			//Copy-Paste del if de arriba
			int i;
			parseo:for(i = 0; i<=this.numContactos;i++){//parsea el arreglo
				if((this.contactos[i].getApellidos().equals(datos.getApellidos())) == false){//ve que los apellidos sean diferentes
					if(this.contactos[i].getApellidos().compareTo(datos.getApellidos()) < 0){//ve si el apellido nuevo es igual al que esta parseando en el momento
						ultimo = "true";
					}else{
						ultimo = "false";
						break parseo;
					}
				}else{//los apellidos son iguales
					for(i = i; i <= this.numContactos && this.contactos[i].getApellidos().equals(datos.getApellidos());i++){
						if(this.contactos[i].getNombre().compareTo(datos.getNombre()) < 0){//ve si el nombre nuevo es igual al que esta parseando en el momento
							ultimo = "true nom";
						}else{
							ultimo = "false";
							break parseo;
						}
					}
					break parseo;
				}
			}
			if(ultimo == "true"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else if(ultimo == "true nom"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else{
				this.recorrerDatosPosi(i);
				this.contactos[i] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}
			this.numContactos++;
		}
	}

	public boolean borrarContacto(int borrar){
		if(this.contactos[borrar].getNombre().equals("") || this.contactos[borrar].getNombre().equals(null) || this.numContactos< borrar){
			return false;
		}else{
			this.recorrerDatosNega(borrar);
			this.numContactos--;
			JOptionPane.showMessageDialog(null, "Borrado!");
			return true;
		}
	}

	public void buscarContacto(String buscar){
		String arrayContactos[] = new String[numContactos];
		
		if(this.numContactos != 0){
			if(buscar != ""){
				for(int i = 0; i<this.numContactos; i++){
					if(this.contactos[i].contiene(buscar) == true){
						arrayContactos[i] = this.contactos[i].toString();
						System.out.println(this.contactos[i].toString());
					}
				}
			}else{
				for(int i = 0; i<this.numContactos; i++){
					arrayContactos[i] = this.contactos[i].toString();
					System.out.println(this.contactos[i].toString());
				}
			}
			crearTabla(arrayContactos);
		}else{
			JOptionPane.showMessageDialog(null, "Agenda Vacia!");
		}
	}
	//----------------------------------------------------------------------------------------------------------------------------------------
	
	private void crearTabla(String[] arrayContactos){
		JFrame panelBoton = new JFrame();
		//JPanel panelBoton = Principal.panelBoton;
		//panelBoton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelBoton.setTitle("Creating a Table Example");
		panelBoton.setSize(800, 800);
		panelBoton.setLocationRelativeTo(null);
		        
		//Object[][] arrayContactos = {{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
		String[] titulosColumnas = {"Nombre", "Apellidos", "Categoria", "Correo", "Telefono", "Celular", "Direccion", "Nota"};
		StringTokenizer st;
		StringTokenizer st2;
		String arContactos[][] = new String[numContactos][8];
		String tmp;
		for(int i = 0; i < arrayContactos.length; i++){
			try{
				st = new StringTokenizer(arrayContactos[i],"\n");
				for(int j = 0; st.hasMoreTokens(); j++){
					try{
						st2 = new StringTokenizer(st.nextToken(),":	");
						tmp = st2.nextToken();
						arContactos[i][j] = st2.nextToken();
					}catch(NullPointerException e){}
				}
			}catch(NullPointerException e){}
		}
		JTable tabla = new JTable(arContactos, titulosColumnas);
		JScrollPane sp = new JScrollPane(tabla);
		System.out.println(tabla.getValueAt(0, 0));
		TableModel tabModel = tabla.getModel();
		System.out.println(tabModel.getValueAt(0, 0).toString());
		panelBoton.add(sp, BorderLayout.NORTH);

		JLabel txt = new JLabel("Al cerrar la principal se cierra esta ventana.\n (Cierre esta ventana antes de buscar un contacto de nuevo)");
		Font myFont= new Font ("Comic Sans MS", 1, 13);
		txt.setFont(myFont);
		txt.setBounds(80, 0, 500, 50);
		panelBoton.add(txt);

		panelBoton.setVisible(true);
	}
	//----------------------------------------------------------------------------------------------------------------------------------------
	//Metodos Extras:
	private void recorrerDatosPosi(int mover){
		for(int i = this.numContactos - 1; i>=mover; i--){
			this.contactos[i+1] = this.contactos[i];
		}
	}
	private void recorrerDatosNega(int mover){
		int i;
		for(i = mover; i < (this.numContactos - 1); i++){
			this.contactos[i] = this.contactos[i+1];
		}
		this.contactos[i] = new Contacto("","","","","","","","");
	}

	private void aumentarObjeto(){
		Contacto[] temp = new Contacto[this.numContactos+1];
		for(int i = 0; i < this.numContactos;i++){
			temp[i] = this.contactos[i];
		}
		this.contactos = new Contacto[this.numContactos+1];
		for(int i = 0; i < this.numContactos;i++){
			this.contactos[i] = temp[i];
		}
	}
}