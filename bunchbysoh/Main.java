package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int[] SoHs = new int[presentCapacities.length];
//    calculation of individual SoH% for batteries
    for(int i=0;i<presentCapacities.length;i++){
      SoHs[i] = 100 * presentCapacities[i] / 120;
//      System.out.println(SoHs[i]);
    }
//    classification of batteries
    for (int soH : SoHs) {
        if (soH > 80 && soH <= 100) {
            counts.healthy++;
        } else if (soH >= 62 && soH <= 80) {
            counts.exchange++;
        } else {
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