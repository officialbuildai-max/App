package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f25474a;

    /* renamed from: b, reason: collision with root package name */
    private final DataOutputStream f25475b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f25474a = byteArrayOutputStream;
        this.f25475b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f25474a.reset();
        try {
            b(this.f25475b, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            b(this.f25475b, str);
            this.f25475b.writeLong(eventMessage.durationMs);
            this.f25475b.writeLong(eventMessage.f25473id);
            this.f25475b.write(eventMessage.messageData);
            this.f25475b.flush();
            return this.f25474a.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
