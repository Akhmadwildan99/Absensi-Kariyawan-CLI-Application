package exception.validationUtil;

import exception.annotationPackage.NotBlank;

import java.lang.reflect.Field;

public class ValidationUtil {

    public static void validate(Object o){
        Class aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (var field : fields){
            field.setAccessible(true);

            if (field.getAnnotation(NotBlank.class) != null){
                try{
                    String value = (String) field.get(o);
                    if (value == null || value.isBlank()){
                        throw new NullPointerException("Field " + field.getName() + " is Null or is Blank");
                    }
                } catch (IllegalAccessException accessException){
                    System.out.println("Tidak bisa mengakses field " + field.getName());
                }
            }
        }
    }
}
