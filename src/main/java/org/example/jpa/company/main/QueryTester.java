package org.example.jpa.company.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QueryTester {

    public static void main(String[] args) throws Exception {
        String unitName = "EmployeeService";

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(unitName);
        EntityManager em = emf.createEntityManager();
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.print("JP QL> ");
            String query = reader.readLine();
            if (query.equals("quit")) {
                break;
            }
            if (query.length() == 0) {
                continue;
            }
            
           

            try {
                
                Query jpaQuery = null;
                List result = null;
                String[] queryParameters = query.split("\\|");
                
                if(queryParameters.length == 2){
                    jpaQuery = em.createQuery(queryParameters[1]);
                    result = new ArrayList<>();
                    result.add(jpaQuery.getSingleResult());
                    
                } else if(queryParameters.length == 3){
                   jpaQuery = em.createQuery(queryParameters[2]);
                   jpaQuery.setMaxResults(Integer.valueOf(queryParameters[1]));
                   result = jpaQuery.getResultList();
                } else {
                    jpaQuery = em.createQuery(query);
                    result = jpaQuery.getResultList();
                }
                                                         
                
                if (result.size() > 0) {
                    int count = 0;
                    for (Object o : result) {
                        System.out.print(++count + " ");
                        printResult(o);
                    }
                } else {
                    System.out.println("0 results returned");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printResult(Object result) throws Exception {
        if (result == null) {
            System.out.print("NULL");
        } else if (result instanceof Object[]) {
            Object[] row = (Object[]) result;
            System.out.println("[");
            for (int i = 0; i < row.length; i++) {
                printResult(row[i]);
            }
            System.out.print("]");
        } else if (result instanceof Long ||
                   result instanceof Double ||
                   result instanceof String) {
            System.out.print(result);
        } else {
            System.out.print(ReflectionToStringBuilder.toString(result,
                                                   ToStringStyle.SHORT_PREFIX_STYLE));
        }
        System.out.println();
    }
}
