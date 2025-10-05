package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        Set<Integer> multiplos = new HashSet<>();
        Set<Integer> vistos = new HashSet<>();
        while (it.hasNext()) {
            Iterator<Integer> itVistos = vistos.iterator();
            int candidato = it.next();
            while (itVistos.hasNext()) {
                int numVisto = itVistos.next();
                if (candidato != 0 && numVisto != 0) {
                    if (candidato % numVisto == 0) {
                        multiplos.add(candidato);
                    }
                    else {
                        if (numVisto % candidato == 0) {
                            multiplos.add (numVisto);
                        }
                    }
                }
            }
            vistos.add (candidato);
        }
        return multiplos;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        boolean hay1 = false;
        if (cuadrados.contains(1) && noCuadrados.contains(1))
            hay1 = true;
        noCuadrados.addAll(cuadrados);
        if (hay1)
            noCuadrados.remove(1);
        noCuadrados.addAll(cuadrados);
        cuadrados.clear();
        if (hay1)
            cuadrados.add(1);

        Iterator<Integer> it1 = noCuadrados.iterator();
        while (it1.hasNext()){
            int e1 = it1.next();
            if (noCuadrados.contains(e1*e1) && e1 != 1)
                cuadrados.add(e1);
        }
        noCuadrados.removeAll(cuadrados);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        Collection<Set<T>> resultado = new ArrayList<>();
        while (it.hasNext()) {
            T e = it.next();
            boolean noEncontrado = false;
            for (Set<T> auxiliar:resultado) {
                if (!auxiliar.contains(e)) {
                    auxiliar.add(e);
                    noEncontrado = true;
                    break;
                }
            }
            if (!noEncontrado) {
                Set<T> nuevo = new HashSet<>();
                nuevo.add(e);
                resultado.add(nuevo);
            }
        }
        return resultado;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        Collection<Set<T>> resultado = new HashSet<>();
        Iterator<Set<T>> it1 = col.iterator();
        while (it1.hasNext()) {
            Set<T> e1 = it1.next();
            Iterator<Set<T>> it2 = col.iterator();
            while (it2.hasNext()) {
                Set<T> e2 = it2.next();
                if (e1 != e2) {
                    Set<T> auxiliar = new HashSet<>();
                    if (!e1.equals(u) && !e2.equals(u)) {
                        auxiliar.addAll(e1);
                        auxiliar.addAll(e2);
                    }
                    if (auxiliar.equals(u)) {
                        resultado.add(e1);
                        resultado.add(e2);
                        return resultado;
                    }
                }
            }
        }
        return resultado;
    }
}
