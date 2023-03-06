package practica2.Pilas;

public class MainBalanceado{
    public static boolean main(Character[] s, PilaArreglo<Character> p) {
        for (int i=0; i<(s.length);i++){
            if( s[i] == '(' || s[i] == '['){
                p.apilar(s[i]);
            }else{
                if(s[i] == ')'){
                    Character aux = p.desapilar();
                    if(aux != '('){
                        return false;
                    }
                }else{
                    if(s[i] == ']'){
                        Character aux = p.desapilar();
                        if(aux != '['){
                            return false;
                        }
                    }
                }
            }
        }
        if (!(p.esVacia())){
            return false;
        }
        return true;
    }
}