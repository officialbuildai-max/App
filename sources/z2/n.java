package z2;

import androidx.media3.common.util.a1;
import androidx.media3.common.v;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class n extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79327b;

    /* renamed from: c, reason: collision with root package name */
    public final String f79328c;

    /* renamed from: d, reason: collision with root package name */
    public final ImmutableList f79329d;

    /* JADX WARN: Multi-variable type inference failed */
    public n(String str, String str2, List list) {
        super(str);
        androidx.media3.common.util.a.a(!list.isEmpty());
        this.f79327b = str2;
        ImmutableList copyOf = ImmutableList.copyOf((Collection) list);
        this.f79329d = copyOf;
        this.f79328c = (String) copyOf.get(0);
    }

    private static List b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z2.i, androidx.media3.common.x.a
    public void a(v.b bVar) {
        String str = this.f79315a;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c11 = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c11 = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c11 = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c11 = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c11 = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c11 = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c11 = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c11 = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c11 = 11;
                    break;
                }
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c11 = 14;
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c11 = 16;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c11 = 17;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c11 = 18;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c11 = 19;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c11 = 20;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c11 = 21;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c11 = 22;
                    break;
                }
                break;
        }
        try {
            switch (c11) {
                case 0:
                case '\n':
                    bVar.P((CharSequence) this.f79329d.get(0));
                    return;
                case 1:
                case 11:
                    bVar.U((CharSequence) this.f79329d.get(0));
                    return;
                case 2:
                case '\r':
                    String str2 = (String) this.f79329d.get(0);
                    bVar.h0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).g0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    return;
                case 3:
                case 18:
                    bVar.Q((CharSequence) this.f79329d.get(0));
                    return;
                case 4:
                case 19:
                    bVar.O((CharSequence) this.f79329d.get(0));
                    return;
                case 5:
                case 20:
                    bVar.V((CharSequence) this.f79329d.get(0));
                    return;
                case 6:
                case 21:
                    String[] o12 = a1.o1((String) this.f79329d.get(0), "/");
                    bVar.s0(Integer.valueOf(Integer.parseInt(o12[0]))).r0(o12.length > 1 ? Integer.valueOf(Integer.parseInt(o12[1])) : null);
                    return;
                case 7:
                case 17:
                    bVar.p0((CharSequence) this.f79329d.get(0));
                    return;
                case '\b':
                case 16:
                    bVar.t0((CharSequence) this.f79329d.get(0));
                    return;
                case '\t':
                case 22:
                    bVar.i0(Integer.valueOf(Integer.parseInt((String) this.f79329d.get(0))));
                    return;
                case '\f':
                    Integer p11 = Ints.p((String) this.f79329d.get(0));
                    if (p11 == null) {
                        bVar.c0((CharSequence) this.f79329d.get(0));
                        return;
                    }
                    String a11 = j.a(p11.intValue());
                    if (a11 != null) {
                        bVar.c0(a11);
                        return;
                    }
                    return;
                case 14:
                    List b11 = b((String) this.f79329d.get(0));
                    int size = b11.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size != 3) {
                                return;
                            } else {
                                bVar.g0((Integer) b11.get(2));
                            }
                        }
                        bVar.h0((Integer) b11.get(1));
                    }
                    bVar.i0((Integer) b11.get(0));
                    return;
                case 15:
                    List b12 = b((String) this.f79329d.get(0));
                    int size2 = b12.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 != 3) {
                                return;
                            } else {
                                bVar.j0((Integer) b12.get(2));
                            }
                        }
                        bVar.k0((Integer) b12.get(1));
                    }
                    bVar.l0((Integer) b12.get(0));
                    return;
                default:
                    return;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return Objects.equals(this.f79315a, nVar.f79315a) && Objects.equals(this.f79327b, nVar.f79327b) && this.f79329d.equals(nVar.f79329d);
    }

    public int hashCode() {
        int hashCode = (527 + this.f79315a.hashCode()) * 31;
        String str = this.f79327b;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f79329d.hashCode();
    }

    @Override // z2.i
    public String toString() {
        return this.f79315a + ": description=" + this.f79327b + ": values=" + this.f79329d;
    }
}
