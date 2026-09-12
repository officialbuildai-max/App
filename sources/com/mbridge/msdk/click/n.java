package com.mbridge.msdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class n {

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f34409d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.setting.g f34410a;

    /* renamed from: b, reason: collision with root package name */
    private String f34411b;

    /* renamed from: c, reason: collision with root package name */
    private int f34412c = 9377;

    public n() {
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        this.f34410a = d11;
        if (d11 == null) {
            this.f34410a = com.mbridge.msdk.setting.h.b().a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.mbridge.msdk.click.entity.a a(String str, String str2) {
        OutputStream outputStream;
        Socket socket;
        int length;
        InputStream inputStream;
        int i11;
        boolean z10;
        Object[] objArr;
        byte[] bArr;
        com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
        Socket socket2 = null;
        OutputStream outputStream2 = null;
        try {
            socket = new Socket(this.f34411b, this.f34412c);
            try {
                socket.setSoTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                outputStream2 = socket.getOutputStream();
                ByteBuffer wrap = ByteBuffer.wrap(new byte[8]);
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                wrap.order(byteOrder);
                wrap.put((byte) 2);
                wrap.put((byte) 3);
                wrap.putShort((short) f34409d.getAndIncrement());
                if (TextUtils.isEmpty(str2)) {
                    wrap.putInt(0);
                    outputStream2.write(wrap.array());
                    length = 0;
                } else {
                    byte[] a11 = a(str2);
                    length = a11.length;
                    wrap.putInt(length);
                    outputStream2.write(wrap.array());
                    outputStream2.write(a11);
                }
                outputStream2.flush();
                o0.a("SocketSpider", "Socket Request : header : " + Arrays.toString(wrap.array()) + " length : " + length);
                inputStream = socket.getInputStream();
                byte[] bArr2 = new byte[8];
                inputStream.read(bArr2, 0, 8);
                ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
                wrap2.order(byteOrder);
                i11 = wrap2.getInt(4);
                byte b11 = bArr2[1];
                z10 = b11 == 3;
                objArr = b11 == 2;
                o0.b("SocketSpider", "Socket Response : header : " + Arrays.toString(bArr2) + " length : " + i11 + " isGzip : " + z10);
                bArr = new byte[i11];
                new DataInputStream(socket.getInputStream()).readFully(bArr);
                if (!z10 && i11 > 2 && ((bArr[0] << 8) | (bArr[1] & 255)) == 8075) {
                    z10 = true;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                socket2 = socket;
                try {
                    o0.a("SocketSpider", "Socket exception: " + th.getMessage());
                    aVar.f34372h = th.getMessage();
                    if (socket2 != null) {
                        try {
                            socket2.close();
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        } catch (Exception e11) {
                            o0.b("SocketSpider", e11.getMessage());
                        }
                    }
                    return aVar;
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        if (objArr == true && i11 == 0) {
            aVar.f34370f = 200;
            aVar.f34371g = str;
            aVar.f34369e = 0;
            try {
                socket.close();
                outputStream2.close();
            } catch (Exception e12) {
                o0.b("SocketSpider", e12.getMessage());
            }
            return aVar;
        }
        if (i11 < 1) {
            aVar.f34370f = 200;
            aVar.f34371g = str;
            aVar.f34369e = 0;
            try {
                socket.close();
                outputStream2.close();
            } catch (Exception e13) {
                o0.b("SocketSpider", e13.getMessage());
            }
            return aVar;
        }
        try {
            String a12 = z10 ? a(bArr) : new String(bArr);
            if (!TextUtils.isEmpty(a12)) {
                aVar.f34370f = 200;
                aVar.f34371g = str;
                aVar.f34369e = 0;
                try {
                    JSONObject optJSONObject = new JSONObject(a12).optJSONObject("data");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString(RequestParameters.SUBRESOURCE_LOCATION);
                        if (!TextUtils.isEmpty(optString)) {
                            aVar.f34370f = Sdk$SDKError.Reason.INVALID_IFA_STATUS_VALUE;
                            aVar.f34365a = optString;
                        }
                    }
                } catch (Throwable th4) {
                    o0.b("SocketSpider", th4.getMessage());
                }
                try {
                    socket.close();
                    outputStream2.close();
                } catch (Exception e14) {
                    o0.b("SocketSpider", e14.getMessage());
                }
                return aVar;
            }
        } catch (Throwable th5) {
            o0.b("SocketSpider", th5.getMessage());
            aVar.f34372h = th5.getMessage();
        }
        inputStream.close();
        try {
            socket.close();
            outputStream2.close();
        } catch (Exception e15) {
            o0.b("SocketSpider", e15.getMessage());
        }
        return aVar;
    }

    private JSONObject b(String str, CampaignEx campaignEx, boolean z10, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                String path = parse.getPath();
                String encodedQuery = parse.getEncodedQuery();
                this.f34411b = host;
                jSONObject.put("uri", "https://" + host + path);
                jSONObject.put("data", encodedQuery);
            }
        } catch (Throwable th2) {
            o0.b("SocketSpider", th2.getMessage());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!z10 && !z11) {
                jSONObject2.put("User-Agent", k0.i());
            }
            if (campaignEx != null) {
                if (z10 && campaignEx.getcUA() == 1) {
                    jSONObject2.put("User-Agent", k0.i());
                }
                if (z11 && campaignEx.getImpUA() == 1) {
                    jSONObject2.put("User-Agent", k0.i());
                }
            } else {
                jSONObject2.put("User-Agent", k0.i());
            }
            jSONObject2.put("Accept-Encoding", "gzip");
            if (this.f34410a.I0() && !TextUtils.isEmpty(str)) {
                jSONObject2.put(RequestParameters.SUBRESOURCE_REFERER, str);
            }
            jSONObject.put("header", jSONObject2);
        } catch (Throwable th3) {
            o0.b("SocketSpider", th3.getMessage());
        }
        return jSONObject;
    }

    public com.mbridge.msdk.click.entity.a a(String str, CampaignEx campaignEx, boolean z10, boolean z11) {
        com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
        aVar.f34371g = str;
        if (TextUtils.isEmpty(str)) {
            aVar.f34372h = "request url can not null.";
            return aVar;
        }
        String replace = str.replace(" ", "%20");
        JSONObject b11 = b(replace, campaignEx, z10, z11);
        if (b11.length() == 0) {
            aVar.f34372h = "request content generation failed.";
            return aVar;
        }
        if (TextUtils.isEmpty(b11.optString("uri"))) {
            aVar.f34372h = "request url parse error.";
            return aVar;
        }
        if (campaignEx != null) {
            int trackingTcpPort = campaignEx.getTrackingTcpPort();
            if (trackingTcpPort == 0) {
                trackingTcpPort = 9377;
            }
            this.f34412c = trackingTcpPort;
        }
        if (!TextUtils.isEmpty(this.f34411b)) {
            return a(replace, b11.toString());
        }
        aVar.f34372h = "request url parse error.";
        return aVar;
    }

    public String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read <= 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public byte[] a(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
