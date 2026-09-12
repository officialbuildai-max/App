package org.apache.tools.ant.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static final d f71724a = d.k();

    /* renamed from: b, reason: collision with root package name */
    private static final z00.c f71725b = new z00.b(new z00.a());

    private static int a(t tVar, t tVar2) {
        BufferedInputStream bufferedInputStream;
        int read;
        int i11;
        int read2;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(tVar.e());
            try {
                bufferedInputStream = new BufferedInputStream(tVar2.e());
                do {
                    try {
                        read = bufferedInputStream3.read();
                        if (read == -1) {
                            i11 = bufferedInputStream.read() == -1 ? 0 : -1;
                            d.b(bufferedInputStream3);
                            d.b(bufferedInputStream);
                            return i11;
                        }
                        read2 = bufferedInputStream.read();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream3;
                        d.b(bufferedInputStream2);
                        d.b(bufferedInputStream);
                        throw th;
                    }
                } while (read == read2);
                i11 = read > read2 ? 1 : -1;
                d.b(bufferedInputStream3);
                d.b(bufferedInputStream);
                return i11;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    public static int b(t tVar, t tVar2, boolean z10) {
        if (tVar.equals(tVar2)) {
            return 0;
        }
        boolean k11 = tVar.k();
        boolean k12 = tVar2.k();
        if (!k11 && !k12) {
            return 0;
        }
        if (k11 != k12) {
            return k11 ? 1 : -1;
        }
        boolean j11 = tVar.j();
        boolean j12 = tVar2.j();
        if (j11 && j12) {
            return 0;
        }
        return (j11 || j12) ? j11 ? -1 : 1 : z10 ? c(tVar, tVar2) : a(tVar, tVar2);
    }

    private static int c(t tVar, t tVar2) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(tVar.e()));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(tVar2.e()));
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                String readLine2 = bufferedReader.readLine();
                if (!readLine.equals(readLine2)) {
                    int compareTo = readLine.compareTo(readLine2);
                    d.d(bufferedReader2);
                    d.d(bufferedReader);
                    return compareTo;
                }
            }
            int i11 = bufferedReader.readLine() == null ? 0 : -1;
            d.d(bufferedReader2);
            d.d(bufferedReader);
            return i11;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader3 = bufferedReader2;
            d.d(bufferedReader3);
            d.d(bufferedReader);
            throw th;
        }
    }
}
