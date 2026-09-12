package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
class NamespaceRemovingInputStream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f19082a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f19083b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class StringPrefixSlicer {

        /* renamed from: a, reason: collision with root package name */
        private String f19084a;

        public StringPrefixSlicer(String str) {
            this.f19084a = str;
        }

        public String a() {
            return this.f19084a;
        }

        public boolean b(String str) {
            if (!this.f19084a.startsWith(str)) {
                return false;
            }
            this.f19084a = this.f19084a.substring(str.length());
            return true;
        }

        public boolean c(String str) {
            int indexOf = this.f19084a.indexOf(str);
            if (indexOf < 0) {
                return false;
            }
            this.f19084a = this.f19084a.substring(indexOf + str.length());
            return true;
        }

        public boolean d(String str) {
            if (!this.f19084a.startsWith(str)) {
                return false;
            }
            while (this.f19084a.startsWith(str)) {
                this.f19084a = this.f19084a.substring(str.length());
            }
            return true;
        }
    }

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.f19082a = new byte[200];
        this.f19083b = false;
    }

    private int l(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.b("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (!stringPrefixSlicer.b(UrlUtils.EQUAL_MARK)) {
            return -1;
        }
        stringPrefixSlicer.d(" ");
        if (stringPrefixSlicer.b("\"") && stringPrefixSlicer.c("\"")) {
            return str.length() - stringPrefixSlicer.a().length();
        }
        return -1;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        k();
        int read = ((FilterInputStream) this).in.read();
        if (read != 120 || this.f19083b) {
            return read;
        }
        this.f19082a[0] = (byte) read;
        ((FilterInputStream) this).in.mark(this.f19082a.length);
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.f19082a;
        int read2 = inputStream.read(bArr, 1, bArr.length - 1);
        ((FilterInputStream) this).in.reset();
        int l11 = l(new String(this.f19082a, 0, read2 + 1, StringUtils.f19086a));
        if (l11 <= 0) {
            return read;
        }
        for (int i11 = 0; i11 < l11 - 1; i11++) {
            ((FilterInputStream) this).in.read();
        }
        int read3 = ((FilterInputStream) this).in.read();
        this.f19083b = true;
        return read3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int read = read();
            if (read == -1) {
                if (i13 == 0) {
                    return -1;
                }
                return i13;
            }
            bArr[i13 + i11] = (byte) read;
        }
        return i12;
    }
}
