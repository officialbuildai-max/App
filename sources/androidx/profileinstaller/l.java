package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f14137a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f14138b = {112, 114, 109, 0};

    private static void A(byte[] bArr, int i11, int i12, e eVar) {
        int m11 = m(i11, i12, eVar.f14125g);
        int i13 = m11 / 8;
        bArr[i13] = (byte) ((1 << (m11 % 8)) | bArr[i13]);
    }

    private static void B(InputStream inputStream) {
        f.h(inputStream);
        int j11 = f.j(inputStream);
        if (j11 == 6 || j11 == 7) {
            return;
        }
        while (j11 > 0) {
            f.j(inputStream);
            for (int j12 = f.j(inputStream); j12 > 0; j12--) {
                f.h(inputStream);
            }
            j11--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean C(OutputStream outputStream, byte[] bArr, e[] eVarArr) {
        if (Arrays.equals(bArr, n.f14150a)) {
            P(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, n.f14151b)) {
            O(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, n.f14153d)) {
            M(outputStream, eVarArr);
            return true;
        }
        if (Arrays.equals(bArr, n.f14152c)) {
            N(outputStream, eVarArr);
            return true;
        }
        if (!Arrays.equals(bArr, n.f14154e)) {
            return false;
        }
        L(outputStream, eVarArr);
        return true;
    }

    private static void D(OutputStream outputStream, e eVar) {
        int[] iArr = eVar.f14126h;
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = iArr[i11];
            f.p(outputStream, i13 - i12);
            i11++;
            i12 = i13;
        }
    }

    private static o E(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f.p(byteArrayOutputStream, eVarArr.length);
            int i11 = 2;
            for (e eVar : eVarArr) {
                f.q(byteArrayOutputStream, eVar.f14121c);
                f.q(byteArrayOutputStream, eVar.f14122d);
                f.q(byteArrayOutputStream, eVar.f14125g);
                String j11 = j(eVar.f14119a, eVar.f14120b, n.f14150a);
                int k11 = f.k(j11);
                f.p(byteArrayOutputStream, k11);
                i11 = i11 + 14 + k11;
                f.n(byteArrayOutputStream, j11);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i11 == byteArray.length) {
                o oVar = new o(FileSectionType.DEX_FILES, i11, byteArray, false);
                byteArrayOutputStream.close();
                return oVar;
            }
            throw f.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void F(OutputStream outputStream, byte[] bArr) {
        outputStream.write(f14137a);
        outputStream.write(bArr);
    }

    private static void G(OutputStream outputStream, e eVar) {
        K(outputStream, eVar);
        D(outputStream, eVar);
        I(outputStream, eVar);
    }

    private static void H(OutputStream outputStream, e eVar, String str) {
        f.p(outputStream, f.k(str));
        f.p(outputStream, eVar.f14123e);
        f.q(outputStream, eVar.f14124f);
        f.q(outputStream, eVar.f14121c);
        f.q(outputStream, eVar.f14125g);
        f.n(outputStream, str);
    }

    private static void I(OutputStream outputStream, e eVar) {
        byte[] bArr = new byte[k(eVar.f14125g)];
        for (Map.Entry entry : eVar.f14127i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                A(bArr, 2, intValue, eVar);
            }
            if ((intValue2 & 4) != 0) {
                A(bArr, 4, intValue, eVar);
            }
        }
        outputStream.write(bArr);
    }

    private static void J(OutputStream outputStream, int i11, e eVar) {
        byte[] bArr = new byte[l(i11, eVar.f14125g)];
        for (Map.Entry entry : eVar.f14127i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i12 = 0;
            for (int i13 = 1; i13 <= 4; i13 <<= 1) {
                if (i13 != 1 && (i13 & i11) != 0) {
                    if ((i13 & intValue2) == i13) {
                        int i14 = (eVar.f14125g * i12) + intValue;
                        int i15 = i14 / 8;
                        bArr[i15] = (byte) ((1 << (i14 % 8)) | bArr[i15]);
                    }
                    i12++;
                }
            }
        }
        outputStream.write(bArr);
    }

    private static void K(OutputStream outputStream, e eVar) {
        int i11 = 0;
        for (Map.Entry entry : eVar.f14127i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                f.p(outputStream, intValue - i11);
                f.p(outputStream, 0);
                i11 = intValue;
            }
        }
    }

    private static void L(OutputStream outputStream, e[] eVarArr) {
        f.p(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            String j11 = j(eVar.f14119a, eVar.f14120b, n.f14154e);
            f.p(outputStream, f.k(j11));
            f.p(outputStream, eVar.f14127i.size());
            f.p(outputStream, eVar.f14126h.length);
            f.q(outputStream, eVar.f14121c);
            f.n(outputStream, j11);
            Iterator it = eVar.f14127i.keySet().iterator();
            while (it.hasNext()) {
                f.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i11 : eVar.f14126h) {
                f.p(outputStream, i11);
            }
        }
    }

    private static void M(OutputStream outputStream, e[] eVarArr) {
        f.r(outputStream, eVarArr.length);
        for (e eVar : eVarArr) {
            int size = eVar.f14127i.size() * 4;
            String j11 = j(eVar.f14119a, eVar.f14120b, n.f14153d);
            f.p(outputStream, f.k(j11));
            f.p(outputStream, eVar.f14126h.length);
            f.q(outputStream, size);
            f.q(outputStream, eVar.f14121c);
            f.n(outputStream, j11);
            Iterator it = eVar.f14127i.keySet().iterator();
            while (it.hasNext()) {
                f.p(outputStream, ((Integer) it.next()).intValue());
                f.p(outputStream, 0);
            }
            for (int i11 : eVar.f14126h) {
                f.p(outputStream, i11);
            }
        }
    }

    private static void N(OutputStream outputStream, e[] eVarArr) {
        byte[] b11 = b(eVarArr, n.f14152c);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, b11);
    }

    private static void O(OutputStream outputStream, e[] eVarArr) {
        byte[] b11 = b(eVarArr, n.f14151b);
        f.r(outputStream, eVarArr.length);
        f.m(outputStream, b11);
    }

    private static void P(OutputStream outputStream, e[] eVarArr) {
        Q(outputStream, eVarArr);
    }

    private static void Q(OutputStream outputStream, e[] eVarArr) {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(E(eVarArr));
        arrayList.add(c(eVarArr));
        arrayList.add(d(eVarArr));
        long length2 = n.f14150a.length + f14137a.length + 4 + (arrayList.size() * 16);
        f.q(outputStream, arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            o oVar = (o) arrayList.get(i11);
            f.q(outputStream, oVar.f14157a.getValue());
            f.q(outputStream, length2);
            if (oVar.f14160d) {
                byte[] bArr = oVar.f14159c;
                long length3 = bArr.length;
                byte[] b11 = f.b(bArr);
                arrayList2.add(b11);
                f.q(outputStream, b11.length);
                f.q(outputStream, length3);
                length = b11.length;
            } else {
                arrayList2.add(oVar.f14159c);
                f.q(outputStream, oVar.f14159c.length);
                f.q(outputStream, 0L);
                length = oVar.f14159c.length;
            }
            length2 += length;
        }
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            outputStream.write((byte[]) arrayList2.get(i12));
        }
    }

    private static int a(e eVar) {
        Iterator it = eVar.f14127i.entrySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return i11;
    }

    private static byte[] b(e[] eVarArr, byte[] bArr) {
        int i11 = 0;
        int i12 = 0;
        for (e eVar : eVarArr) {
            i12 += f.k(j(eVar.f14119a, eVar.f14120b, bArr)) + 16 + (eVar.f14123e * 2) + eVar.f14124f + k(eVar.f14125g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i12);
        if (Arrays.equals(bArr, n.f14152c)) {
            int length = eVarArr.length;
            while (i11 < length) {
                e eVar2 = eVarArr[i11];
                H(byteArrayOutputStream, eVar2, j(eVar2.f14119a, eVar2.f14120b, bArr));
                G(byteArrayOutputStream, eVar2);
                i11++;
            }
        } else {
            for (e eVar3 : eVarArr) {
                H(byteArrayOutputStream, eVar3, j(eVar3.f14119a, eVar3.f14120b, bArr));
            }
            int length2 = eVarArr.length;
            while (i11 < length2) {
                G(byteArrayOutputStream, eVarArr[i11]);
                i11++;
            }
        }
        if (byteArrayOutputStream.size() == i12) {
            return byteArrayOutputStream.toByteArray();
        }
        throw f.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i12);
    }

    private static o c(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        for (int i12 = 0; i12 < eVarArr.length; i12++) {
            try {
                e eVar = eVarArr[i12];
                f.p(byteArrayOutputStream, i12);
                f.p(byteArrayOutputStream, eVar.f14123e);
                i11 = i11 + 4 + (eVar.f14123e * 2);
                D(byteArrayOutputStream, eVar);
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            o oVar = new o(FileSectionType.CLASSES, i11, byteArray, true);
            byteArrayOutputStream.close();
            return oVar;
        }
        throw f.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
    }

    private static o d(e[] eVarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 0;
        for (int i12 = 0; i12 < eVarArr.length; i12++) {
            try {
                e eVar = eVarArr[i12];
                int a11 = a(eVar);
                byte[] e11 = e(a11, eVar);
                byte[] f11 = f(eVar);
                f.p(byteArrayOutputStream, i12);
                int length = e11.length + 2 + f11.length;
                f.q(byteArrayOutputStream, length);
                f.p(byteArrayOutputStream, a11);
                byteArrayOutputStream.write(e11);
                byteArrayOutputStream.write(f11);
                i11 = i11 + 6 + length;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i11 == byteArray.length) {
            o oVar = new o(FileSectionType.METHODS, i11, byteArray, true);
            byteArrayOutputStream.close();
            return oVar;
        }
        throw f.c("Expected size " + i11 + ", does not match actual size " + byteArray.length);
    }

    private static byte[] e(int i11, e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            J(byteArrayOutputStream, i11, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static byte[] f(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            K(byteArrayOutputStream, eVar);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static String h(String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    private static e i(e[] eVarArr, String str) {
        if (eVarArr.length <= 0) {
            return null;
        }
        String h11 = h(str);
        for (int i11 = 0; i11 < eVarArr.length; i11++) {
            if (eVarArr[i11].f14120b.equals(h11)) {
                return eVarArr[i11];
            }
        }
        return null;
    }

    private static String j(String str, String str2, byte[] bArr) {
        String a11 = n.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a11);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, a11);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + n.a(bArr) + str2;
    }

    private static int k(int i11) {
        return z(i11 * 2) / 8;
    }

    private static int l(int i11, int i12) {
        return z(Integer.bitCount(i11 & (-2)) * i12) / 8;
    }

    private static int m(int i11, int i12, int i13) {
        if (i11 == 1) {
            throw f.c("HOT methods are not stored in the bitmap");
        }
        if (i11 == 2) {
            return i12;
        }
        if (i11 == 4) {
            return i12 + i13;
        }
        throw f.c("Unexpected flag: " + i11);
    }

    private static int[] n(InputStream inputStream, int i11) {
        int[] iArr = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += f.h(inputStream);
            iArr[i13] = i12;
        }
        return iArr;
    }

    private static int o(BitSet bitSet, int i11, int i12) {
        int i13 = bitSet.get(m(2, i11, i12)) ? 2 : 0;
        return bitSet.get(m(4, i11, i12)) ? i13 | 4 : i13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] p(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, f.d(inputStream, bArr.length))) {
            return f.d(inputStream, n.f14151b.length);
        }
        throw f.c("Invalid magic");
    }

    private static void q(InputStream inputStream, e eVar) {
        int available = inputStream.available() - eVar.f14124f;
        int i11 = 0;
        while (inputStream.available() > available) {
            i11 += f.h(inputStream);
            eVar.f14127i.put(Integer.valueOf(i11), 1);
            for (int h11 = f.h(inputStream); h11 > 0; h11--) {
                B(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw f.c("Read too much data during profile line parse");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e[] r(InputStream inputStream, byte[] bArr, byte[] bArr2, e[] eVarArr) {
        if (Arrays.equals(bArr, n.f14155f)) {
            if (Arrays.equals(n.f14150a, bArr2)) {
                throw f.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return s(inputStream, bArr, eVarArr);
        }
        if (Arrays.equals(bArr, n.f14156g)) {
            return u(inputStream, bArr2, eVarArr);
        }
        throw f.c("Unsupported meta version");
    }

    static e[] s(InputStream inputStream, byte[] bArr, e[] eVarArr) {
        if (!Arrays.equals(bArr, n.f14155f)) {
            throw f.c("Unsupported meta version");
        }
        int j11 = f.j(inputStream);
        byte[] e11 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
        try {
            e[] t11 = t(byteArrayInputStream, j11, eVarArr);
            byteArrayInputStream.close();
            return t11;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static e[] t(InputStream inputStream, int i11, e[] eVarArr) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i11 != eVarArr.length) {
            throw f.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i11];
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int h11 = f.h(inputStream);
            iArr[i12] = f.h(inputStream);
            strArr[i12] = f.f(inputStream, h11);
        }
        for (int i13 = 0; i13 < i11; i13++) {
            e eVar = eVarArr[i13];
            if (!eVar.f14120b.equals(strArr[i13])) {
                throw f.c("Order of dexfiles in metadata did not match baseline");
            }
            int i14 = iArr[i13];
            eVar.f14123e = i14;
            eVar.f14126h = n(inputStream, i14);
        }
        return eVarArr;
    }

    static e[] u(InputStream inputStream, byte[] bArr, e[] eVarArr) {
        int h11 = f.h(inputStream);
        byte[] e11 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
        try {
            e[] v11 = v(byteArrayInputStream, bArr, h11, eVarArr);
            byteArrayInputStream.close();
            return v11;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static e[] v(InputStream inputStream, byte[] bArr, int i11, e[] eVarArr) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        if (i11 != eVarArr.length) {
            throw f.c("Mismatched number of dex files found in metadata");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            f.h(inputStream);
            String f11 = f.f(inputStream, f.h(inputStream));
            long i13 = f.i(inputStream);
            int h11 = f.h(inputStream);
            e i14 = i(eVarArr, f11);
            if (i14 == null) {
                throw f.c("Missing profile key: " + f11);
            }
            i14.f14122d = i13;
            int[] n11 = n(inputStream, h11);
            if (Arrays.equals(bArr, n.f14154e)) {
                i14.f14123e = h11;
                i14.f14126h = n11;
            }
        }
        return eVarArr;
    }

    private static void w(InputStream inputStream, e eVar) {
        BitSet valueOf = BitSet.valueOf(f.d(inputStream, f.a(eVar.f14125g * 2)));
        int i11 = 0;
        while (true) {
            int i12 = eVar.f14125g;
            if (i11 >= i12) {
                return;
            }
            int o11 = o(valueOf, i11, i12);
            if (o11 != 0) {
                Integer num = (Integer) eVar.f14127i.get(Integer.valueOf(i11));
                if (num == null) {
                    num = 0;
                }
                eVar.f14127i.put(Integer.valueOf(i11), Integer.valueOf(o11 | num.intValue()));
            }
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e[] x(InputStream inputStream, byte[] bArr, String str) {
        if (!Arrays.equals(bArr, n.f14151b)) {
            throw f.c("Unsupported version");
        }
        int j11 = f.j(inputStream);
        byte[] e11 = f.e(inputStream, (int) f.i(inputStream), (int) f.i(inputStream));
        if (inputStream.read() > 0) {
            throw f.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e11);
        try {
            e[] y10 = y(byteArrayInputStream, str, j11);
            byteArrayInputStream.close();
            return y10;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private static e[] y(InputStream inputStream, String str, int i11) {
        if (inputStream.available() == 0) {
            return new e[0];
        }
        e[] eVarArr = new e[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int h11 = f.h(inputStream);
            int h12 = f.h(inputStream);
            eVarArr[i12] = new e(str, f.f(inputStream, h11), f.i(inputStream), 0L, h12, (int) f.i(inputStream), (int) f.i(inputStream), new int[h12], new TreeMap());
        }
        for (int i13 = 0; i13 < i11; i13++) {
            e eVar = eVarArr[i13];
            q(inputStream, eVar);
            eVar.f14126h = n(inputStream, eVar.f14123e);
            w(inputStream, eVar);
        }
        return eVarArr;
    }

    private static int z(int i11) {
        return (i11 + 7) & (-8);
    }
}
