import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main 
{
    private static boolean filter_nb(Notebook nb, Map<String, String> filter) 
    {
        boolean result = true;
        for (String key: filter.keySet()) 
        {
            String value = filter.get(key);
            if (key.equals("1")) 
            {
                try 
                {
                    int i = Integer.parseInt(value);
                    if (nb.getRamSize() < i) 
                    {
                        result = false;
                        break;
                    }
                } 
                catch (NumberFormatException e) 
                {
                    result = false;
                    break;
                }
            } 
            else if (key.equals("2")) 
            {
                try 
                {
                    int i = Integer.parseInt(value);
                    if (nb.getDiskSize() < i) 
                    {
                        result = false;
                        break;
                    }
                } 
                catch (NumberFormatException e)
                {
                    result = false;
                    break;
                }
            } 
            else if (key.equals("3")) 
            {
                try 
                {
                    int i = Integer.parseInt(value);
                    if (nb.getScreenSizeInch() < i) 
                    {
                        result = false;
                        break;
                    }
                } 
                catch (NumberFormatException e) 
                {
                    result = false;
                    break;
                }
            } 
            else if (key.equals("4")) 
            {
                if (!nb.getColor().equalsIgnoreCase(value)) 
                {
                    result = false;
                    break;
                }
            } 
            else if (key.equals("5")) 
            {
                if (!nb.getOs().toUpperCase().contains(value.toUpperCase())) 
                {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private static void printNotebooks(Set<Notebook> nb, Map<String, String> filter) 
    {
        List<String> forPrint = new ArrayList<String>();
        for (Notebook i: nb) 
        {
            if (filter_nb(i, filter)) 
            {
                String s = String.format("Ноутбук: %s, ОЗУ(Гб): %d, Диск(Гб): %d, Экран(дюйм): %d, ОС: %s, цвет: %s",
                    i.getNbName(), i.getRamSize(), i.getDiskSize(), i.getScreenSizeInch(), i.getOs(), i.getColor());
                forPrint.add(s);
            }
        }

        System.out.printf("\nРезультат %d из %d\n", forPrint.size(), nb.size());
        for (String s: forPrint) 
        {
            System.out.println(s);
        }
    }

    public static void main(String[] params) 
    {
        Set<Notebook> nb = new HashSet<Notebook>();

        nb.add(new Notebook("PDOP1233",15,8,512,"Windows 10","Pink"));
        nb.add(new Notebook("RBSU7721",17,8,128,"Linux","Black"));
        nb.add(new Notebook("MLF40127",17,4,4000,"Linux","White"));
        nb.add(new Notebook("SBH2003",15,16,1024,"Windows 10","Blue"));
        nb.add(new Notebook("GBSU3331",17,32,3000,"Windows 10","Gold"));
        nb.add(new Notebook("SLH2077",15,32,2000,"MacOS","Silver"));
        Scanner iScanner = new Scanner(System.in);
        Map<String, String> filter = new HashMap<String, String>();

        printNotebooks(nb, filter);
        while (true) 
        {
            System.out.println("\nВведите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - Минимальный объём ОЗУ (Гб)");
            System.out.println("2 - Минимальный объём ЖД (Гб)");
            System.out.println("3 - Размер экрана (дюйм)");
            System.out.println("4 - Цвет (Black, White, Blue...)");
            System.out.println("5 - Операционная система (Windows, MacOS, Linux)");
            System.out.println("6 - Выход");
            System.out.print("Выберите пункт - ");

            List<String> criteriesInteger = Arrays.asList("1","2","3");
            List<String> criteriesString = Arrays.asList("4","5");
            String key = iScanner.nextLine();
            key = key.trim();

            if (key.equals("6")) 
            {
                break;
            }
            if (criteriesInteger.contains(key) || criteriesString.contains(key)) 
            {
                System.out.print("Введите значение - ");
                String value = iScanner.nextLine();
                value = value.trim();

                if (value.equals("")) 
                {
                    filter.put(key, value);
                } 
                else 
                {
                    if (criteriesString.contains(key))
                    {
                        filter.put(key, value);
                    } 
                    else 
                    {
                        try 
                        {
                            Integer.parseInt(value);
                            filter.put(key, value);
                        } 
                        catch (NumberFormatException e) 
                        {
                            System.out.println("\n!! Введите числовое значение !!");
                            continue;
                        }
                    }
                }
                printNotebooks(nb, filter);
            } 
            else 
            {
                System.out.printf("\nПункт %s отсутствует", key);
            }
        }
        iScanner.close();
    }
}