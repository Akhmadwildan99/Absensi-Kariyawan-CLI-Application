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

    public static void validateIfNull(Integer integer) throws NumberFormatException, NullPointerException{
        if (integer == null ){
            throw new NullPointerException("integer is null");
        } else if (integer.equals(Integer.valueOf(""))){
            throw new NumberFormatException("Not number format");
        }
    }
}
