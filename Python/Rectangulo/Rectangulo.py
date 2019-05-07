class Rectangulo():
  
  alto = 0
  ancho = 0
  
  def __init__(self, alto, ancho):
    self.alto = alto;
    self.ancho = ancho;
  
  # Devuelve el valor del alto del rectángulo.
  def getAlto(self):
    return self
  
  
  # Asigna el valor del alto al rectángulo.
  def setAlto(self, alto):
    try:
      if self.alto > 10 | self.alto < 0:
        raise TypeError("Valor no válido.")
        self.alto = alto
    
    except:
      print("Número no válido.")
  
  
  # Devuelve el valor del ancho del rectángulo.
  def getAncho(self):
    return self
  
  
  # Asigna el valor del ancho al rectángulo.
  def setAncho(self, ancho):
    try:
      if self.ancho > 10 | self.ancho < 1:
        raise TypeError("Valor no válido.")
        self.ancho = ancho
      
    except TypeError:
      print("Número no válido.")
      
  
  def __str__(self):
    altura = ""
    anchura = ""
    
    for num in range(self.ancho):
      anchura += ("* ")
      anchura += ("  ")
      
      if num == 0 | num == (self.ancho - 1):
        altura += ("* ")
        
      else:
        altura += ("  ")
      
    if self.alto > 1 | self.ancho > 1:
      print(anchura)
      for num in range(self.alto - 2):
        print(altura)
      
      if self.alto > 1:
        print(anchura)
    else:
      print("*")
      
