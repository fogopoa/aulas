package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.util.ArrayList;
/**
 * 
 * @author cristina.mallmann@gmail.com
 *
 */
public class ListaDiretorio {
	
	//Se tiver lista
	private void listaCheia(File root, String[] resultado,
			ArrayList<String> diretorios, ArrayList<String> arqs) {

			resultado[0] = "list: " + root;
			resultado[1] = "total: " + Integer.valueOf(root.listFiles().length);

			for (int i = 2, l = 0; l < diretorios.size(); i++, l++) {
				resultado[i] = diretorios.get(l);
			}
			for (int i = (2 + diretorios.size()), y = 0; y < arqs.size(); i++, y++) {
				resultado[i] = arqs.get(y);
			}
		}

	    //Se não tiver lista
		private String[] listaVazia(File arquivo) {

			String[] resultado;
			resultado = new String[] { "list: " + arquivo,
					"total: " + Integer.valueOf(arquivo.listFiles().length), };
			return resultado;

		}
    //valida diretorio e arquivos
	public String[] listaConteudoDiretorio(String dir) {

		if (dir == null || dir.isEmpty()) {
			throw new IllegalArgumentException();
		}

		File root = new File(dir);

		if (!root.exists() || !root.isDirectory()) {
			throw new IllegalArgumentException();
		}

		return listCompleta(root);
	}

	private String[] listCompleta(File arquivo) {

		File[] listaArquivos = arquivo.listFiles();

		return uneTudo(arquivo, listaArquivos);

	}
    //Criando resultado
	private String[] uneTudo(File root, File[] listaArquivos) {
	
        //Criando array
		ArrayList<String> dirs = new ArrayList<String>();
		ArrayList<String> arqs = new ArrayList<String>();
		
		String[] resultado = new String[(int) (2 + root.listFiles().length)];

		if (root.listFiles().length > 0) {
			for (int i = 0; i < root.listFiles().length; i++) {
				if (listaArquivos[i].isDirectory()) {
					dirs.add("d " + listaArquivos[i].getName());
				} else {
					arqs.add("a " + listaArquivos[i].getName());
				}
			}

			listaCheia(root, resultado, dirs, arqs);

		} else {
			resultado = listaVazia(root);
		}

		return resultado;
	}



}