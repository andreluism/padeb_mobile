package utils;


public class JaroWinkler{
  public final static JaroWinkler INSTANCE = new JaroWinkler();
  final double winkler;
  final int prefix;

  protected JaroWinkler() {
    winkler = 0.1;
    prefix = 0;
  }

  public JaroWinkler(double weight, int length) {
    winkler = weight;
    prefix = length;
  }

  public double similarity(String strA, String strB) {
    if (strA.equals(strB)) return 1.0;
    if (strA.length() > strB.length()) {
      String tmp = strB;
      strB = strA;
      strA = tmp;
    }
    int lenA = strA.length();
    if (lenA == 0) return 0.0;
    int idxA, idxB, last;
    int lenB = strB.length();
    int cpcA = strA.codePointCount(0, lenA);
    int cpcB = strB.codePointCount(0, lenB);
    int[] cpA = StringUtils.toCodePointArray(strA, cpcA);
    boolean[] matchedA = new boolean[cpcA];
    int[] cpB = StringUtils.toCodePointArray(strB, cpcB);
    boolean[] matchedB = new boolean[cpcB];
    int matchWindow = Math.max(0, cpcB / 2 - 1);
    int matching = 0;
    for (idxA = 0; idxA < cpcA; ++idxA) {
      last = Math.min(cpcB, idxA + matchWindow + 1);
      for (idxB = Math.max(0, idxA - matchWindow); idxB < last; ++idxB) {
        if (!matchedB[idxB] && cpA[idxA] == cpB[idxB]) {
          matching++; 
          matchedA[idxA] = true;
          matchedB[idxB] = true;
          break;
        }
      }
    }
    if (matching == 0) return 0.0;
    int transpositions = 0;
    idxB = 0;
    for (idxA = 0; idxA < cpcA; idxA++) {
      if (matchedA[idxA]) {
        while (!matchedB[idxB])
          ++idxB;
        if (cpA[idxA] != cpB[idxB]) ++transpositions;
        ++idxB;
      }
    }
    transpositions /= 2;
    double commonsDouble = (double) matching;
    double score = commonsDouble / cpcA + commonsDouble / cpcB;
    score += (commonsDouble - (double) transpositions) / commonsDouble;
    score /= 3;
    return (winkler == 0.0 || prefix == 0) ? score : prefixBoost(score, Math.min(prefix, cpcA),
        cpA, cpB);
  }

  private double prefixBoost(double score, int last, int[] cpA, int[] cpB) {
    int commons = 0; 
    for (; commons < last && cpA[commons] == cpB[commons]; ++commons);
    return score + winkler * commons * (1.0 - score);
  }
}
