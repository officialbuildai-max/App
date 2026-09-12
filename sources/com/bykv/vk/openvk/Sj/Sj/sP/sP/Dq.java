package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Dq {

    /* renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f20279a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Sj extends Exception {
        Sj(Throwable th2) {
            super(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dq(File file, String str) {
        try {
            this.f20279a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e11) {
            throw new Sj(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(byte[] bArr) {
        try {
            return this.f20279a.read(bArr);
        } catch (IOException e11) {
            throw new Sj(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        f6.a.n(this.f20279a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j11) {
        try {
            this.f20279a.seek(j11);
        } catch (IOException e11) {
            throw new Sj(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(byte[] bArr, int i11, int i12) {
        try {
            this.f20279a.write(bArr, i11, i12);
        } catch (IOException e11) {
            throw new Sj(e11);
        }
    }
}
