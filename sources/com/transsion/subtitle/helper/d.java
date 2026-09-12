package com.transsion.subtitle.helper;

import android.util.Base64;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.blankj.utilcode.util.o;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.transsion.subtitle.bean.OpenSubtitleData;
import com.transsion.subtitle.bean.OpenSubtitleDownloadInfo;
import com.transsion.subtitle.bean.OpenSubtitleResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f55021a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f55022b = {37, 79, 19, 106, 49, 88};

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f55023c = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.helper.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b k11;
            k11 = d.k();
            return k11;
        }
    });

    private d() {
    }

    private final List b(String str) {
        byte[] decode = Base64.decode(StringsKt.n1(str).toString(), 11);
        Intrinsics.e(decode);
        if (decode.length == 0) {
            return null;
        }
        int length = decode.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            byte[] bArr2 = f55022b;
            bArr[i11] = (byte) (bArr2[i11 % bArr2.length] ^ decode[i11]);
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.g(UTF_8, "UTF_8");
        List S0 = StringsKt.S0(new String(bArr, UTF_8), new String[]{"#@!@#"}, false, 3, 2, null);
        if (S0.size() == 3) {
            return S0;
        }
        return null;
    }

    private final String c(String str) {
        int hashCode = str.hashCode();
        return hashCode != 3588 ? hashCode != 3886 ? (hashCode == 100341365 && str.equals("in_id")) ? "id" : str : !str.equals("zh") ? str : "zh-cn" : !str.equals("pt") ? str : "pt-pt";
    }

    private final b e() {
        return (b) f55023c.getValue();
    }

    private final String f(InputStream inputStream) {
        try {
            try {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    char[] cArr = new char[512];
                    StringBuffer stringBuffer = new StringBuffer();
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        intRef.element = read;
                        if (read == -1) {
                            break;
                        }
                        stringBuffer.append(cArr, 0, read);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return stringBuffer2;
                } catch (Throwable th2) {
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th2;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                    return null;
                }
            }
        } catch (UnsupportedEncodingException e12) {
            e12.printStackTrace();
            inputStream.close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00da, code lost:
    
        if (r0 == null) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.transsion.subtitle.helper.b i() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.helper.d.i():com.transsion.subtitle.helper.b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b k() {
        return f55021a.i();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "lan"
            kotlin.jvm.internal.Intrinsics.h(r2, r0)
            int r0 = r2.hashCode()
            switch(r0) {
                case 3121: goto L9a;
                case 3148: goto L8e;
                case 3241: goto L82;
                case 3276: goto L76;
                case 3329: goto L6a;
                case 3355: goto L5e;
                case 3651: goto L52;
                case 3684: goto L46;
                case 3741: goto L38;
                case 101385: goto L2a;
                case 106936941: goto L1c;
                case 115814250: goto Le;
                default: goto Lc;
            }
        Lc:
            goto La2
        Le:
            java.lang.String r0 = "zh-cn"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L18
            goto La2
        L18:
            java.lang.String r2 = "中文(简体)"
            goto La7
        L1c:
            java.lang.String r0 = "pt-pt"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L26
            goto La2
        L26:
            java.lang.String r2 = "Português"
            goto La7
        L2a:
            java.lang.String r0 = "fil"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L34
            goto La2
        L34:
            java.lang.String r2 = "Filipino"
            goto La7
        L38:
            java.lang.String r0 = "ur"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L42
            goto La2
        L42:
            java.lang.String r2 = "اردو"
            goto La7
        L46:
            java.lang.String r0 = "sw"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4f
            goto La2
        L4f:
            java.lang.String r2 = "Swahili"
            goto La7
        L52:
            java.lang.String r0 = "ru"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L5b
            goto La2
        L5b:
            java.lang.String r2 = "Русский"
            goto La7
        L5e:
            java.lang.String r0 = "id"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L67
            goto La2
        L67:
            java.lang.String r2 = "Indonesia"
            goto La7
        L6a:
            java.lang.String r0 = "hi"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L73
            goto La2
        L73:
            java.lang.String r2 = "हिन्दी"
            goto La7
        L76:
            java.lang.String r0 = "fr"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L7f
            goto La2
        L7f:
            java.lang.String r2 = "Français"
            goto La7
        L82:
            java.lang.String r0 = "en"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L8b
            goto La2
        L8b:
            java.lang.String r2 = "English"
            goto La7
        L8e:
            java.lang.String r0 = "bn"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L97
            goto La2
        L97:
            java.lang.String r2 = "বাংলা"
            goto La7
        L9a:
            java.lang.String r0 = "ar"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto La5
        La2:
            java.lang.String r2 = ""
            goto La7
        La5:
            java.lang.String r2 = "عربي"
        La7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.helper.d.d(java.lang.String):java.lang.String");
    }

    public final Object g(String str, Continuation continuation) {
        String str2;
        b e11 = e();
        String str3 = e11.b() + "download";
        try {
            a.C0856a c0856a = lg.a.f68962a;
            com.transsion.baselib.report.a aVar = com.transsion.baselib.report.a.f43394a;
            c0856a.x(aVar.a(), "Subtitle new api download info start:" + str + " ", true);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str3).openConnection());
            Intrinsics.f(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", e11.c());
            httpURLConnection.setRequestProperty("Api-Key", e11.a());
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.getDoOutput();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                outputStreamWriter.write("{\"file_id\":" + str + "}");
                outputStreamWriter.flush();
                Unit unit = Unit.f67184a;
                CloseableKt.a(outputStream, null);
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.g(inputStream, "getInputStream(...)");
                if (httpURLConnection.getResponseCode() == 200) {
                    c0856a.c(aVar.a(), "Subtitle new api, download info success ", true);
                    str2 = f(inputStream);
                } else {
                    c0856a.x(aVar.a(), "Subtitle new api download info fail ", true);
                    str2 = null;
                }
                return (OpenSubtitleDownloadInfo) o.d(str2, OpenSubtitleDownloadInfo.class);
            } finally {
            }
        } catch (Throwable th2) {
            com.google.firebase.perf.metrics.h e12 = pc.e.c().e(str3, "GET");
            Intrinsics.g(e12, "newHttpMetric(...)");
            e12.a(th2 instanceof SSLHandshakeException ? 87 : th2 instanceof ProtocolException ? 86 : th2 instanceof IOException ? 88 : th2 instanceof TimeoutException ? 85 : 89);
            th2.printStackTrace();
            lg.a.f68962a.c(com.transsion.baselib.report.a.f43394a.a(), "Subtitle new api download info fail: " + th2 + " ", true);
            return null;
        }
    }

    public final Object h(String str, String str2, Integer num, Integer num2, Continuation continuation) {
        String str3;
        String str4;
        List<OpenSubtitleData> data;
        String lowerCase = new Regex("[\\\\/:#*?\"<>|&,]").replace(str, "").toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        String c11 = c(str2);
        b e11 = e();
        if (num == null && num2 == null) {
            str3 = e11.b() + "subtitles?query=" + lowerCase + "&languages=" + c11;
        } else {
            str3 = e11.b() + "subtitles?query=" + lowerCase + "&languages=" + c11 + "&season_number=" + num + "&episode_number=" + num2;
        }
        try {
            a.C0856a c0856a = lg.a.f68962a;
            com.transsion.baselib.report.a aVar = com.transsion.baselib.report.a.f43394a;
            c0856a.c(aVar.a(), "new api getSubtitleInfo url:" + str3, true);
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str3).openConnection());
            Intrinsics.f(uRLConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", e11.c());
            httpURLConnection.setRequestProperty("Api-Key", e11.a());
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.g(inputStream, "getInputStream(...)");
            if (httpURLConnection.getResponseCode() == 200) {
                c0856a.c(aVar.a(), "Subtitle new api success ", true);
                str4 = f(inputStream);
            } else {
                c0856a.x(aVar.a(), "Subtitle new api fail ", true);
                str4 = null;
            }
            OpenSubtitleResponse openSubtitleResponse = (OpenSubtitleResponse) o.d(str4, OpenSubtitleResponse.class);
            if (openSubtitleResponse != null && (data = openSubtitleResponse.getData()) != null && !data.isEmpty()) {
                return CollectionsKt.U0(openSubtitleResponse.getData());
            }
            j(3, ConstantsKt.ERROR_1000_MESSAGE);
            return null;
        } catch (Throwable th2) {
            String message = th2.getMessage();
            j(3, message != null ? message : "");
            th2.printStackTrace();
            com.google.firebase.perf.metrics.h e12 = pc.e.c().e(str3, "GET");
            Intrinsics.g(e12, "newHttpMetric(...)");
            e12.a(th2 instanceof SSLHandshakeException ? 87 : th2 instanceof ProtocolException ? 86 : th2 instanceof IOException ? 88 : th2 instanceof TimeoutException ? 85 : 89);
            lg.a.f68962a.i(com.transsion.baselib.report.a.f43394a.a(), "new api getSubtitleInfo FAIL :" + th2, true);
            return null;
        }
    }

    public final void j(int i11, String msg) {
        Intrinsics.h(msg, "msg");
        HashMap hashMap = new HashMap();
        hashMap.put("from", String.valueOf(i11));
        hashMap.put(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, msg);
        hj.i.f64628a.s("subtitle_search", "app_perf", hashMap);
    }
}
