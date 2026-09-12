package x9;

import java.util.Locale;

/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f78270a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f78271b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f78272c;

    /* renamed from: d, reason: collision with root package name */
    private final int f78273d;

    private n(String[] strArr, int[] iArr, String[] strArr2, int i11) {
        this.f78270a = strArr;
        this.f78271b = iArr;
        this.f78272c = strArr2;
        this.f78273d = i11;
    }

    public static n b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new n(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    private static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        boolean z10;
        strArr[0] = "";
        int i11 = 0;
        int i12 = 0;
        while (i11 < str.length()) {
            int indexOf = str.indexOf("$", i11);
            if (indexOf == -1) {
                String valueOf = String.valueOf(strArr[i12]);
                String valueOf2 = String.valueOf(str.substring(i11));
                strArr[i12] = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                i11 = str.length();
            } else if (indexOf != i11) {
                String valueOf3 = String.valueOf(strArr[i12]);
                String valueOf4 = String.valueOf(str.substring(i11, indexOf));
                strArr[i12] = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                i11 = indexOf;
            } else if (str.startsWith("$$", i11)) {
                strArr[i12] = String.valueOf(strArr[i12]).concat("$");
                i11 += 2;
            } else {
                int i13 = i11 + 1;
                int indexOf2 = str.indexOf("$", i13);
                String substring = str.substring(i13, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i12] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2.concat("d");
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals("Number")) {
                                z10 = false;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals("Time")) {
                                z10 = true;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals("Bandwidth")) {
                                z10 = 2;
                                break;
                            }
                            break;
                    }
                    z10 = -1;
                    switch (z10) {
                        case false:
                            iArr[i12] = 2;
                            break;
                        case true:
                            iArr[i12] = 4;
                            break;
                        case true:
                            iArr[i12] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException(str.length() != 0 ? "Invalid template: ".concat(str) : new String("Invalid template: "));
                    }
                    strArr2[i12] = str2;
                }
                i12++;
                strArr[i12] = "";
                i11 = indexOf2 + 1;
            }
        }
        return i12;
    }

    public String a(String str, long j11, int i11, long j12) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        while (true) {
            int i13 = this.f78273d;
            if (i12 >= i13) {
                sb2.append(this.f78270a[i13]);
                return sb2.toString();
            }
            sb2.append(this.f78270a[i12]);
            int i14 = this.f78271b[i12];
            if (i14 == 1) {
                sb2.append(str);
            } else if (i14 == 2) {
                sb2.append(String.format(Locale.US, this.f78272c[i12], Long.valueOf(j11)));
            } else if (i14 == 3) {
                sb2.append(String.format(Locale.US, this.f78272c[i12], Integer.valueOf(i11)));
            } else if (i14 == 4) {
                sb2.append(String.format(Locale.US, this.f78272c[i12], Long.valueOf(j12)));
            }
            i12++;
        }
    }
}
