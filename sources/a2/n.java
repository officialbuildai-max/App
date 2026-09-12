package a2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final List f207a;

    /* renamed from: b, reason: collision with root package name */
    private final List f208b;

    /* renamed from: c, reason: collision with root package name */
    private final List f209c;

    private n(List list, List list2, List list3) {
        this.f207a = list;
        this.f208b = list2;
        this.f209c = list3;
    }

    public static n b(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        c(str, arrayList, arrayList2, arrayList3);
        return new n(arrayList, arrayList2, arrayList3);
    }

    private static void c(String str, List list, List list2, List list3) {
        String str2;
        boolean z10;
        list.add("");
        int i11 = 0;
        while (i11 < str.length()) {
            int indexOf = str.indexOf("$", i11);
            if (indexOf == -1) {
                list.set(list2.size(), ((String) list.get(list2.size())) + str.substring(i11));
                i11 = str.length();
            } else if (indexOf != i11) {
                list.set(list2.size(), ((String) list.get(list2.size())) + str.substring(i11, indexOf));
                i11 = indexOf;
            } else if (str.startsWith("$$", i11)) {
                list.set(list2.size(), ((String) list.get(list2.size())) + "$");
                i11 += 2;
            } else {
                list3.add("");
                int i12 = i11 + 1;
                int indexOf2 = str.indexOf("$", i12);
                String substring = str.substring(i12, indexOf2);
                if (substring.equals("RepresentationID")) {
                    list2.add(1);
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2 + "d";
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
                            list2.add(2);
                            break;
                        case true:
                            list2.add(4);
                            break;
                        case true:
                            list2.add(3);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    list3.set(list2.size() - 1, str2);
                }
                list.add("");
                i11 = indexOf2 + 1;
            }
        }
    }

    public String a(String str, long j11, int i11, long j12) {
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < this.f208b.size(); i12++) {
            sb2.append((String) this.f207a.get(i12));
            if (((Integer) this.f208b.get(i12)).intValue() == 1) {
                sb2.append(str);
            } else if (((Integer) this.f208b.get(i12)).intValue() == 2) {
                sb2.append(String.format(Locale.US, (String) this.f209c.get(i12), Long.valueOf(j11)));
            } else if (((Integer) this.f208b.get(i12)).intValue() == 3) {
                sb2.append(String.format(Locale.US, (String) this.f209c.get(i12), Integer.valueOf(i11)));
            } else if (((Integer) this.f208b.get(i12)).intValue() == 4) {
                sb2.append(String.format(Locale.US, (String) this.f209c.get(i12), Long.valueOf(j12)));
            }
        }
        sb2.append((String) this.f207a.get(this.f208b.size()));
        return sb2.toString();
    }
}
