package org.juliangranda.java8.lambda;

import org.juliangranda.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        //Predicate siempre devuelve un boolean.
        Predicate<Integer> test = num -> num > 10;
        boolean resultado = test.test(11);
        System.out.println("resultado = " + resultado);

        Predicate<String> test2 = role -> role.equals("Role_ADMIN");
        System.out.println(test2.test("Role_ADMIN"));

        //(a,b) -> a.equals(b);
        BiPredicate<String, String> test3 = String::equals;
        System.out.println(test3.test("andres","andres"));

        BiPredicate<Integer, Integer> test4 = (i, j) -> j > i;
        boolean res = test4.test(4,7);
        System.out.println(res);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("maria");
        b.setNombre("cata");

        BiPredicate<Usuario,Usuario> t5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a,b));
    }
}
