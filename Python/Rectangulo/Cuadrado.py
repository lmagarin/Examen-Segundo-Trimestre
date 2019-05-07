from tetraedros import Rectangulo

class Cuadrado(Rectangulo):
  
  def __init__(self, alto):
    super().__init__(alto, alto);
    
  # Método para modificar el lado
  def set_lado(self, lado):
    self.setAlto(lado);
    self.setAncho(lado);

  # Método para devolver el valor del lado del cuadrado
  def get_lado(self):
    return self.getAlto;
  
  # Método para comparar los cuadrados
  def comparable(self, cuadrado):
    if self.alto == cuadrado.alto:
      return "Los cuadrados son iguales"
    if self.alto < cuadrado.alto:
      return "El primer cuadrado es menor que el dado"
    if self.alto > cuadrado.alto:
      return "EL primer cuadrado es mayor que el dado"
  
  if __name__ == "__main__": 
    # lado=int(input('Inserte el lado del cuadrado: '))
    cuadrado = Cuadrado(9)
    print(cuadrado)
    cuadrado2 = Cuadrado(6)

