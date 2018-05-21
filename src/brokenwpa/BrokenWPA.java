/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brokenwpa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jefaokpta
 */
public class BrokenWPA {

    public static void main(String[] args) {
        List chars=new ArrayList();
        chars.add("0");chars.add("5");chars.add("9");chars.add("V");chars.add("v");chars.add("c");chars.add("o");chars.add("m");
//        chars.add("a");chars.add("b");chars.add("c");chars.add("d");chars.add("e");chars.add("f");chars.add("g");chars.add("h");chars.add("i");chars.add("j");
//        chars.add("k");chars.add("l");chars.add("m");chars.add("n");chars.add("o");chars.add("p");chars.add("q");chars.add("r");chars.add("s");chars.add("t");
//        chars.add("u");chars.add("v");chars.add("w");chars.add("x");chars.add("y");chars.add("z");
        
//        chars.add("0");chars.add("1");chars.add("2");chars.add("3");chars.add("4");chars.add("5");chars.add("6");chars.add("7");chars.add("8");chars.add("9"); 
//        chars.add("!");chars.add("@");chars.add("#");chars.add("$");

//        chars.add("A");chars.add("B");chars.add("C");chars.add("D");
//        chars.add("E");chars.add("F");chars.add("G");chars.add("H");chars.add("I");chars.add("J");chars.add("K");chars.add("L");chars.add("M");chars.add("N");
//        chars.add("O");chars.add("P");chars.add("Q");chars.add("R");chars.add("S");chars.add("T");chars.add("U");chars.add("V");chars.add("W");chars.add("X");
//        chars.add("Y");chars.add("Z");
//        
//        
//        chars.add("%");chars.add("^");chars.add("&");chars.add("*");
//        chars.add("(");chars.add(")");chars.add("´");chars.add("`");chars.add("~");chars.add("-");chars.add("_");chars.add("=");chars.add("+");chars.add(" ");
//        chars.add("|");chars.add("[");chars.add("]");chars.add("{");chars.add("}");chars.add(";");chars.add(":");chars.add("'");chars.add("\"");chars.add(",");
//        chars.add(".");chars.add("<");chars.add(">");chars.add("/");chars.add("?");
        
        int lines=0;
        int linesLimit=100000000;
        int control=1;
        File wl=new File("/tmp/worldlist.txt");
        File found=new File("/tmp/found.txt");
        
        try {
            FileWriter fwrite=new FileWriter(wl);
            FileWriter log=new FileWriter(new File("/tmp/brokenLog.txt"));
            for (Object p1 : chars) {
                for (Object p2 : chars) {
                    for (Object p3 : chars) {
                        for (Object p4 : chars) {
                            for (Object p5 : chars) {
                                for (Object p6 : chars) {
                                    for (Object p7 : chars) {
                                        for (Object p8 : chars) {
                                            fwrite.write(p1+""+p2+""+p3+""+p4+""+p5+""+p6+""+p7+""+p8+"\n");
                                            lines++;
                                            if(lines>linesLimit){
                                                System.out.println(Calendar.getInstance().getTime());
                                                System.out.println("Analizando "+lines+" senhas geradas LEVEL 1, volte daqui umas 5 horas ou mais");
                                                log.write(Calendar.getInstance().getTime()+"\n");
                                                log.write("Analizando "+lines+" senhas geradas LEVEL 1, volte daqui umas 5 horas ou mais\n");
                                                log.flush();
                                                lines=0;
                                                fwrite.flush();
                                                fwrite.close();
                                                Process proc=Runtime.getRuntime().exec("/usr/bin/aircrack-ng "+args[0]+" -w /tmp/"+wl.getName()+" -l /tmp/found.txt");
                                                InputStream stdout=proc.getInputStream();
                                                while (stdout.read()>=0)
                                                if(found.exists()){
                                                    System.out.println(Calendar.getInstance().getTime());
                                                    System.out.println("Senha encontrada!!!!");     
                                                    log.write(Calendar.getInstance().getTime()+"\n");
                                                    log.write("SENHA ENCONTRADA\n");
                                                    BufferedReader br=new BufferedReader(new FileReader(found));
                                                    while(br.ready()){
                                                        String senha=br.readLine();
                                                        log.write(senha);
                                                        System.out.println(senha);                                                      
                                                    }
                                                    log.flush();
                                                    log.close();
                                                    wl.delete();
                                                    System.exit(0);
                                                }
                                                System.out.println(Calendar.getInstance().getTime());
                                                System.out.println("Senha ainda nao encontrada gerando mais....");
                                                log.write(Calendar.getInstance().getTime()+"\n");
                                                log.write("Senha ainda nao encontrada gerando mais....\n");
                                                log.flush();
                                                wl.delete();
                                                wl=new File("/tmp/worldlist"+control+".txt");
                                                fwrite=new FileWriter(wl);
                                                control++;
                                            }
                                            for (Object p9 : chars) {
                                                fwrite.write(p1+""+p2+""+p3+""+p4+""+p5+""+p6+""+p7+""+p8+""+p9+"\n");
                                                lines++;
                                                if(lines>linesLimit){
                                                    System.out.println(Calendar.getInstance().getTime());
                                                    System.out.println("Analizando "+lines+" senhas geradas LEVEL 1, volte daqui umas 5 horas ou mais");
                                                    log.write(Calendar.getInstance().getTime()+"\n");
                                                    log.write("Analizando "+lines+" senhas geradas LEVEL 1, volte daqui umas 5 horas ou mais\n");
                                                    log.flush();
                                                    lines=0;
                                                    fwrite.flush();
                                                    fwrite.close();
                                                    Process proc=Runtime.getRuntime().exec("/usr/bin/aircrack-ng "+args[0]+" -w /tmp/"+wl.getName()+" -l /tmp/found.txt");
                                                    InputStream stdout=proc.getInputStream();
                                                    while (stdout.read()>=0)
                                                    if(found.exists()){
                                                        System.out.println(Calendar.getInstance().getTime());
                                                        System.out.println("Senha encontrada!!!!");     
                                                        log.write(Calendar.getInstance().getTime()+"\n");
                                                        log.write("SENHA ENCONTRADA\n");
                                                        BufferedReader br=new BufferedReader(new FileReader(found));
                                                        while(br.ready()){
                                                            String senha=br.readLine();
                                                            log.write(senha);
                                                            System.out.println(senha);                                                      
                                                        }
                                                        log.flush();
                                                        log.close();
                                                        wl.delete();
                                                        System.exit(0);
                                                    }
                                                    System.out.println(Calendar.getInstance().getTime());
                                                    System.out.println("Senha ainda nao encontrada gerando mais....");
                                                    log.write(Calendar.getInstance().getTime()+"\n");
                                                    log.write("Senha ainda nao encontrada gerando mais....\n");
                                                    log.flush();
                                                    wl.delete();
                                                    wl=new File("/tmp/worldlist"+control+".txt");
                                                    fwrite=new FileWriter(wl);
                                                    control++;
                                                }
                                                for (Object p10 : chars) {
                                                    fwrite.write(p1+""+p2+""+p3+""+p4+""+p5+""+p6+""+p7+""+p8+""+p9+""+p10+"\n");
                                                    lines++;
                                                    if(lines>linesLimit){
                                                        System.out.println(Calendar.getInstance().getTime());
                                                        System.out.println("Analizando "+lines+" senhas geradas LEVEL 1, volte daqui umas 5 horas ou mais");
                                                        log.write(Calendar.getInstance().getTime()+"\n");
                                                        log.write("Analizando "+lines+" senhas geradas LEVEL 1, volte daqui umas 5 horas ou mais\n");
                                                        log.flush();
                                                        lines=0;
                                                        fwrite.flush();
                                                        fwrite.close();
                                                        Process proc=Runtime.getRuntime().exec("/usr/bin/aircrack-ng "+args[0]+" -w /tmp/"+wl.getName()+" -l /tmp/found.txt");
                                                        InputStream stdout=proc.getInputStream();
                                                        while (stdout.read()>=0)
                                                        if(found.exists()){
                                                            System.out.println(Calendar.getInstance().getTime());
                                                            System.out.println("Senha encontrada!!!!");     
                                                            log.write(Calendar.getInstance().getTime()+"\n");
                                                            log.write("SENHA ENCONTRADA\n");
                                                            BufferedReader br=new BufferedReader(new FileReader(found));
                                                            while(br.ready()){
                                                                String senha=br.readLine();
                                                                log.write(senha);
                                                                System.out.println(senha);                                                      
                                                            }
                                                            log.flush();
                                                            log.close();
                                                            wl.delete();
                                                            System.exit(0);
                                                        }
                                                        System.out.println(Calendar.getInstance().getTime());
                                                        System.out.println("Senha ainda nao encontrada gerando mais....");
                                                        log.write(Calendar.getInstance().getTime()+"\n");
                                                        log.write("Senha ainda nao encontrada gerando mais....\n");
                                                        log.flush();
                                                        wl.delete();
                                                        wl=new File("/tmp/worldlist"+control+".txt");
                                                        fwrite=new FileWriter(wl);
                                                        control++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            log.write(Calendar.getInstance().getTime()+"\n");
            log.write("NAO ACREDITO Q ACABOU E NAO ACHO!!!!!!!!/n NAO DEVE SER 8 DIGITOS\n VERIFIQUE O LEVEL");
            log.flush();
        } catch (IOException ex) {
            System.out.println("DEU RUIM: "+ex.getMessage());
        }
        System.out.println(Calendar.getInstance().getTime());      
        System.out.println("NAO ACREDITO Q ACABOU E NAO ACHO!!!!!!!!");
        System.out.println("VERIFIQUE O LEVEL");
        System.out.println("NAO DEVE SER 8 DIGITOS");
        
    }
    
}
