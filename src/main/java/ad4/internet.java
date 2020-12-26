/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class internet {

    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> passports = new ArrayList<>();
        ArrayList<String> required = new ArrayList<>();
        required.add("ecl");
        required.add("pid");
        required.add("eyr");
        required.add("hcl");
        required.add("byr");
        required.add("iyr");
        required.add("hgt");
        int validPassCount = 0;
        try {
            URL path = ClassLoader.getSystemResource("input4.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path.toURI())));
            String line = "";
            while ((line = br.readLine()) != null) {
                a1.add(line);
            }
            br.close();
            int index = 0;
            while (index < a1.size()) {
                String toAdd = "";
                while (index < a1.size() && !a1.get(index).isEmpty()) {
                    toAdd += a1.get(index) + " ";
                    index++;
                }
                passports.add(toAdd);
                index++;
            }
            System.out.println("Passports Array Size: " + passports.size());
            for (int i = 0; i < passports.size(); i++) {
                String pass = passports.get(i);
                Scanner sc = new Scanner(pass);
                ArrayList<String> fields = new ArrayList<>();
                while (sc.hasNext()) {
                    fields.add(sc.next());
                }
                //System.out.println(fields.toString());
                if (fields.size() >= 7) {
                    System.out.println("Number of fields: " + fields.size());
                    int validFieldCount = 0;
                    for (int j = 0; j < fields.size(); j++) {
                        System.out.print("Iteration of fields array: " + j + " ");
                        String field = fields.get(j);
                        String data = field.substring(4, field.length());
                        System.out.print("Field: " + field + " ");
                        if (data.length() >= 3) {
                            if (field.startsWith("ecl")) {
                                if (data.equals("amb") || data.equals("blu") || data.equals("brn")
                                        || data.equals("gry") || data.equals("grn") || data.equals("hzl")
                                        || data.equals("oth")) {
                                    validFieldCount++;
                                }
                            } else if (field.startsWith("pid")) {
                                if (data.length() == 9) {
                                    validFieldCount++;
                                }
                            } else if (field.startsWith("eyr")) {
                                if (data.length() == 4) {
                                    int num = Integer.valueOf(data);
                                    if (num >= 2020 && num <= 2030) {
                                        validFieldCount++;
                                    }
                                }
                            } else if (field.startsWith("hcl")) {
                                if (data.charAt(0) == '#') {
                                    if (data.length() == 7) {
                                        int validCharCount = 0;
                                        for (int y = 1; y < data.length(); y++) {
                                            char ch = data.charAt(y);
                                            if (ch == 'a' || ch == 'b' || ch == 'c' ||
                                                    ch == 'd' || ch == 'e' || ch == 'f' ||
                                                    ch == '0' || ch == '1' || ch == '2' ||
                                                    ch == '3' || ch == '4' || ch == '5' ||
                                                    ch == '6' || ch == '7' || ch == '8' ||
                                                    ch == '9') {
                                                validCharCount++;
                                            }
                                        }
                                        if (validCharCount == 6) {
                                            validFieldCount++;
                                        }
                                    }
                                }
                            } else if (field.startsWith("byr")) {
                                if (data.length() == 4) {
                                    int num = Integer.valueOf(data);
                                    if (num >= 1920 && num <= 2002) {
                                        validFieldCount++;
                                    }
                                }
                            } else if (field.startsWith("iyr")) {
                                if (data.length() == 4) {
                                    int num = Integer.valueOf(data);
                                    if (num >= 2010 && num <= 2020) {
                                        validFieldCount++;
                                    }
                                }
                            } else if (field.startsWith("hgt")) {
                                String units = data.substring(data.length() - 2);
                                try {
                                    int height = Integer.valueOf(data.substring(0, data.length() - 2));
                                    if (units.equals("cm")) {
                                        if (height >= 150 && height <= 193) {
                                            validFieldCount++;
                                        }
                                    } else if (units.equals("in")) {
                                        if (height >= 59 && height <= 76) {
                                            validFieldCount++;
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("NumberFormatException" + e);
                                }
                            }
                        }
                        System.out.println("Number of valid fields: " + validFieldCount);
                    }
                    if (validFieldCount == 7) {
                        validPassCount++;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: " + ex);
        } catch (IOException io) {
            System.out.println("IO Exception: " + io);
        } catch (URISyntaxException uri) {
            System.out.println("URISyntaxException: " + uri);
        }
        System.out.println(validPassCount);
    }
}

