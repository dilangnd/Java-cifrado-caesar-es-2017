package excercise;

public class Criptografia {

	/*
	 * Programa basado en el 
	 * https://en.wikipedia.org/wiki/Caesar_cipher
	 */

	public static void main(String[] args) {
		int key = 17;
		/************************************************************************************
		 * Texto pleno a encriptar                                                          *
		 ************************************************************************************/
		String miTexto="HOLA A TODOS. BIENVENIDOS A MI SISTEMA DE CRIPTOGRAFIA. QUE BUENA COMPAÑIA";
		System.out.println("TEXTO LEGIBLE : ");
		System.out.println("\t"+miTexto);

		String textoEncriptado = encriptar(miTexto,key);
		System.out.println("TEXTO ILEGIBLE : ");
		System.out.println("\t"+textoEncriptado);
		String textoDecriptado = encriptar(textoEncriptado, 27-key);
		System.out.println("OTRA VEZ EL TEXTO ES LEGIBLE : ");
		System.out.println("\t"+textoDecriptado);
		romperElCodigo(textoEncriptado);
	}
	public static String encriptar(String texto, int clave){
		// Coursera 
		/*******************************************************
		 *  Paso 1. Copiar el texto de entrada en una variable *
		 *          
		 ******************************************************/
		StringBuilder encriptado= new StringBuilder(texto);
		/***************************************************************
		 *  Paso 2. Definir el alfabeto original legible               *
		 *          El alfabeto español tiene 27 letras (incluye la Ñ) *
		 *          El alfabeto en inglés tiene 26 letras              *
		 ***************************************************************/
		
		String alfabeto="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; 
		/*************************************************************************************************
		 * Paso 3. Definir el alfabeto destino
		 *   Recordar que:                                                                                 *
		 *   subcadena = nombreDelString.substring (carácter Inicial Incluido, carácter Final Excluido) *
		 *   "smiles".substring (1, 5) devuelve "mile".                                                 *
		 * Tomamos las letras del alfabeto desde la posición 'clave'                                     *
		 * hasta el final del alfabeto y las concatenamos con las primeras letras del alfabeto           *
		 * hasta antes del caracter de la posición 'clave'                                              *
		 *************************************************************************************************/
		String  alfabetoCambiado= alfabeto.substring(clave)+alfabeto.substring(0,clave);
		for (int i=0;i<encriptado.length();i++){
			 // Paso 4. Se toma cada caracter del texto ingresado
			char caracterActual= encriptado.charAt(i);
			 // Paso 5. Se consulta en el alfabeto original
			int idx = alfabeto.indexOf(caracterActual);
			if (idx != -1){
				 // Paso 6. Si el caracter se encuentra,
				 //         se toma el caracter de la misma posición del alfabeto destino
				char nuevoCaracter = alfabetoCambiado.charAt(idx);
				//  Paso 7. Se reemplaza el caracter del texto original con el nuevo
				encriptado.setCharAt(i, nuevoCaracter);
			}
		}
		// Paso 8. Se retorna el texto en el nuevo alfabeto
		return encriptado.toString();
	}
	public static void romperElCodigo(String textoEncriptado){
		System.out.println("══════════════════════════════════════════════════════════════════════════════════");
		System.out.println("KEY  \t\t. . . T E X T O   G E N E R A D O . . . ");
		System.out.println("══════════════════════════════════════════════════════════════════════════════════");
		for (int k=0;k<27;k++){
			System.out.printf("%2d   %s%n",k,encriptar(textoEncriptado,k));
		}
		System.out.println("══════════════════════════════════════════════════════════════════════════════════");
	}
}