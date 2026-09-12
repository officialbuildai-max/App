package com.mbridge.msdk.foundation.same.report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes5.dex */
public class m extends com.mbridge.msdk.tracker.network.toolbox.a {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f35625b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private final byte f35626a;

    public m(byte b11) {
        this.f35626a = b11;
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ee A[Catch: all -> 0x00e4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00e4, blocks: (B:32:0x00a9, B:35:0x00b9, B:38:0x00cb, B:44:0x00ee, B:47:0x0105, B:49:0x0109, B:52:0x0122), top: B:31:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105 A[Catch: all -> 0x00e4, TRY_ENTER, TryCatch #0 {all -> 0x00e4, blocks: (B:32:0x00a9, B:35:0x00b9, B:38:0x00cb, B:44:0x00ee, B:47:0x0105, B:49:0x0109, B:52:0x0122), top: B:31:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0080 A[Catch: all -> 0x005e, TryCatch #5 {all -> 0x005e, blocks: (B:15:0x0044, B:17:0x0055, B:20:0x0059, B:21:0x0067, B:23:0x0074, B:26:0x0078, B:29:0x0081, B:30:0x0099, B:68:0x0080, B:69:0x008f, B:70:0x0064), top: B:14:0x0044 }] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.mbridge.msdk.tracker.network.toolbox.g a(com.mbridge.msdk.tracker.network.t<?> r12, java.util.Map<java.lang.String, java.lang.String> r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.m.a(com.mbridge.msdk.tracker.network.t, java.util.Map):com.mbridge.msdk.tracker.network.toolbox.g");
    }

    public byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
