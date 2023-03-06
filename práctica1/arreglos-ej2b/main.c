#include <stdio.h>
#include <stdlib.h>
#include <string.h> 

#include "arreglo.h"

int main(){
    TData A;
	int i;
    
    A.a[0]= 0;
	A.a[1]= 1;
	A.a[2]= 2;
	A.a[3]= 3;
	A.cant = 4;		
	show (A);
	
	printf("\n");
	ins (&A,99,0);	
	show ( A );
	
	printf("\n");
	delhd (&A);	
	show ( A );
	printf("\nEl primer numero es:%d", at(A, 0));
	
	printf("\n");
	del (&A, 3);	
	show ( A );	

    return 0;
}