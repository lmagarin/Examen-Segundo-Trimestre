from tetraedros import Rectangulo;

if __name__=="__main__": 
  ancho=int(input('Inserte el ancho del rectángulo: '))
  alto=int(input('Inserte el alto del rectángulo: '))
        
  rectangulo=Rectangulo(ancho, alto)
  rectangulo.imprimir()
