package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import java.net.ProtocolException;

/* loaded from: classes5.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Protocol f40595a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40596b;

    /* renamed from: c, reason: collision with root package name */
    public final String f40597c;

    public m(Protocol protocol, int i11, String str) {
        this.f40595a = protocol;
        this.f40596b = i11;
        this.f40597c = str;
    }

    public static m a(String str) {
        Protocol protocol;
        int i11;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i11 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else {
                if (charAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            protocol = Protocol.HTTP_1_0;
            i11 = 4;
        }
        int i12 = i11 + 3;
        if (str.length() < i12) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i11, i12));
            if (str.length() <= i12) {
                str2 = "";
            } else {
                if (str.charAt(i12) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i11 + 4);
            }
            return new m(protocol, parseInt, str2);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f40595a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f40596b);
        if (this.f40597c != null) {
            sb2.append(' ');
            sb2.append(this.f40597c);
        }
        return sb2.toString();
    }
}
