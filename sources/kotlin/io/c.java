package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes7.dex */
public class c extends b {
    public static void c(File file, byte[] array) {
        Intrinsics.h(file, "<this>");
        Intrinsics.h(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f67184a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static void d(File file, String text, Charset charset) {
        Intrinsics.h(file, "<this>");
        Intrinsics.h(text, "text");
        Intrinsics.h(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            l(fileOutputStream, text, charset);
            Unit unit = Unit.f67184a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final ByteBuffer e(int i11, CharsetEncoder encoder) {
        Intrinsics.h(encoder, "encoder");
        ByteBuffer allocate = ByteBuffer.allocate(i11 * ((int) Math.ceil(encoder.maxBytesPerChar())));
        Intrinsics.g(allocate, "allocate(...)");
        return allocate;
    }

    public static final CharsetEncoder f(Charset charset) {
        Intrinsics.h(charset, "<this>");
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        return newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
    }

    public static byte[] g(File file) {
        Intrinsics.h(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i11 = (int) length;
            byte[] bArr = new byte[i11];
            int i12 = i11;
            int i13 = 0;
            while (i12 > 0) {
                int read = fileInputStream.read(bArr, i13, i12);
                if (read < 0) {
                    break;
                }
                i12 -= read;
                i13 += read;
            }
            if (i12 > 0) {
                bArr = Arrays.copyOf(bArr, i13);
                Intrinsics.g(bArr, "copyOf(...)");
            } else {
                int read2 = fileInputStream.read();
                if (read2 != -1) {
                    a aVar = new a(8193);
                    aVar.write(read2);
                    ByteStreamsKt.b(fileInputStream, aVar, 0, 2, null);
                    int size = aVar.size() + i11;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] d11 = aVar.d();
                    byte[] copyOf = Arrays.copyOf(bArr, size);
                    Intrinsics.g(copyOf, "copyOf(...)");
                    bArr = ArraysKt.j(d11, copyOf, i11, 0, aVar.size());
                }
            }
            CloseableKt.a(fileInputStream, null);
            return bArr;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(fileInputStream, th2);
                throw th3;
            }
        }
    }

    public static final String h(File file, Charset charset) {
        Intrinsics.h(file, "<this>");
        Intrinsics.h(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String e11 = TextStreamsKt.e(inputStreamReader);
            CloseableKt.a(inputStreamReader, null);
            return e11;
        } finally {
        }
    }

    public static /* synthetic */ String i(File file, Charset charset, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return h(file, charset);
    }

    public static void j(File file, byte[] array) {
        Intrinsics.h(file, "<this>");
        Intrinsics.h(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            Unit unit = Unit.f67184a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static void k(File file, String text, Charset charset) {
        Intrinsics.h(file, "<this>");
        Intrinsics.h(text, "text");
        Intrinsics.h(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            l(fileOutputStream, text, charset);
            Unit unit = Unit.f67184a;
            CloseableKt.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void l(OutputStream outputStream, String text, Charset charset) {
        Intrinsics.h(outputStream, "<this>");
        Intrinsics.h(text, "text");
        Intrinsics.h(charset, "charset");
        if (text.length() < 16384) {
            byte[] bytes = text.getBytes(charset);
            Intrinsics.g(bytes, "getBytes(...)");
            outputStream.write(bytes);
            return;
        }
        CharsetEncoder f11 = f(charset);
        CharBuffer allocate = CharBuffer.allocate(8192);
        Intrinsics.e(f11);
        ByteBuffer e11 = e(8192, f11);
        int i11 = 0;
        int i12 = 0;
        while (i11 < text.length()) {
            int min = Math.min(8192 - i12, text.length() - i11);
            int i13 = i11 + min;
            char[] array = allocate.array();
            Intrinsics.g(array, "array(...)");
            text.getChars(i11, i13, array, i12);
            allocate.limit(min + i12);
            i12 = 1;
            if (!f11.encode(allocate, e11, i13 == text.length()).isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            outputStream.write(e11.array(), 0, e11.position());
            if (allocate.position() != allocate.limit()) {
                allocate.put(0, allocate.get());
            } else {
                i12 = 0;
            }
            allocate.clear();
            e11.clear();
            i11 = i13;
        }
    }
}
