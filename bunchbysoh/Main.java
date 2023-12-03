package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int[] SoHs = new int[presentCapacities.length];//integer array to store SoHs of each battery
//    calculation of individual SoH% for batteries
    for(int i=0;i<presentCapacities.length;i++){
      SoHs[i] = 100 * presentCapacities[i] / 120;//formula to calculate the SoHs of battery
//      System.out.println(SoHs[i]);
    }
//    classification of batteries
    for (int soH : SoHs) {
        if (soH > 80 && soH <= 100) {//healthy battery SoH condition
            counts.healthy++;
        } else if (soH >= 62 && soH <= 80) {//exchange battery SoH condition
            counts.exchange++;
        } else {//failed case
            counts.failed++;
        }
    }
//    System.out.println(counts.healthy+" "+counts.exchange+" "+counts.failed);
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}