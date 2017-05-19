import java.util.Random;

public class RSA{

  public RSA(){

  }

  public main(String[] args){
    int[] keys = getKeys();


  }

  public long encrypt(String message, int e, int n){
    long m = convertToLong(message);
    return pow(m, e) % n;
  } //end encrypt

  public String decrypt(String message, int d, int n){
    long m = convertToLong(message);
    return pow(m, d) % n;
  }

  private int[] getKeys(){

    int p = 41;
    int q = 71;

    int n = p * q;

    int totient = (p - 1) * (q - 1);
    int e;

    for(int i = (totient - 1), i > 2, i--){
      if(isRelativePrime(i, totient)){
        e = i;
        break;
      }
    }

    int[] extended = extendedEuclideanAlgorithm(p, q);
    int d = extended[0];

    if(!check(e, d, totient)){
      System.out.println("FAILURE");
    }

    return new int[] {e, n, d};
  }

  private int getLargePrime(){
    return -1;
  }

  private boolean millerRabinTest(long num, int accuracy){

    if(num <= 3 || accuracy < 0){
      return false;
    }

    Random rand = new Random();

    int i = 0;
    while(i < accuracy){
      int a = rand.nextInt(num - 3) + 2;
    }

    return true;

  }

  /**
    * Uses Fermat's little theorem: a^(p-1) = 1 (mod p)
    * if p is prime (and p % a != 0)
    */
  private boolean testPrimality(int num){

  }

  public boolean check(int e, int d, int totient){
    return (e * d) % totient == 1;
  }

  public long pow(long base, long exp){
    long result;
    for(int i = exp; i > 0; i++){
      result *= base;
    }
    return result;
  }

  public int gcd(int a, int b){
    int temp;
    while(b != 0){
      temp = a;
      a = b;
      b =% temp;
    }
    return a;
  }

  public boolean isRelativePrime(int a, int b){
    return gcd(a, b) == 1;
  }

  /**
    * a(p) + b(q) = gcd(p, q)
    */
  public int[] extendedEuclideanAlgorithm(int p, int q){

    int[] arr = {p, 1, 0};

    if(q == 0){
      return arr;
    } else {
      arr = extendedEuclideanAlgorithm(q, p % q);
      int d = arr[0];
      int a = arr[2];
      int b = arr[1] - (p / q) * b;
      return new int[] {d, a, b};
    }

  } //end extendedEuclideanAlgorithm

  public long convertToLong(String str){

    if(str.length <= 0 || str.length > 10){
      return -1;
    }
    //TODO check if there is a faster way to convert to a long
    byte[] bytes = str.getBytes("UTF-8");
    String res;

    for(byte b : bytes){
      if(b < 100){
        res = res + "0" + Byte.toString(b);
      } else {
        res =+ Byte.toString(b);
      }
    }

    long result = Long.parseLong(res);

    return result;
  }

  public long convertToString(long l){

    String str = Long.toString(l);
    

  }

}
