package com.transsion.transfer.androidasync.http;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import com.transsion.transfer.androidasync.AsyncServer;

/* loaded from: classes6.dex */
public class HttpUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class EndEmitter extends com.transsion.transfer.androidasync.t {
        private EndEmitter() {
        }

        public static EndEmitter P(AsyncServer asyncServer, final Exception exc) {
            EndEmitter endEmitter = new EndEmitter();
            asyncServer.D(new Runnable() { // from class: com.transsion.transfer.androidasync.http.HttpUtil.EndEmitter.1
                @Override // java.lang.Runnable
                public void run() {
                    EndEmitter.this.M(exc);
                }
            });
            return endEmitter;
        }
    }

    public static long a(Headers headers) {
        String c11 = headers.c(HttpHeaders.CONTENT_LENGTH);
        if (c11 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(c11);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static cv.a b(com.transsion.transfer.androidasync.p pVar, bv.a aVar, Headers headers) {
        String c11 = headers.c(HttpHeaders.CONTENT_TYPE);
        if (c11 == null) {
            return null;
        }
        String[] split = c11.split(";");
        for (int i11 = 0; i11 < split.length; i11++) {
            split[i11] = split[i11].trim();
        }
        for (String str : split) {
            if ("application/x-www-form-urlencoded".equals(str)) {
                return new cv.h();
            }
            if ("application/json".equals(str)) {
                return new cv.b();
            }
            if (ShareConstant.SHARE_TYPE_TEXT.equals(str)) {
                return new cv.f();
            }
            if (str != null && str.startsWith("multipart/")) {
                return new cv.c(c11);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.transsion.transfer.androidasync.p c(com.transsion.transfer.androidasync.p r6, com.transsion.transfer.androidasync.http.Protocol r7, com.transsion.transfer.androidasync.http.Headers r8, boolean r9) {
        /*
            r0 = -1
            java.lang.String r7 = "Content-Length"
            java.lang.String r7 = r8.c(r7)     // Catch: java.lang.NumberFormatException -> Lf
            if (r7 == 0) goto Lf
            long r2 = java.lang.Long.parseLong(r7)     // Catch: java.lang.NumberFormatException -> Lf
            goto L10
        Lf:
            r2 = r0
        L10:
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r0 = 0
            if (r7 == 0) goto L46
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L2e
            com.transsion.transfer.androidasync.AsyncServer r7 = r6.a()
            com.transsion.transfer.androidasync.http.BodyDecoderException r8 = new com.transsion.transfer.androidasync.http.BodyDecoderException
            java.lang.String r9 = "not using chunked encoding, and no content-length found."
            r8.<init>(r9)
            com.transsion.transfer.androidasync.http.HttpUtil$EndEmitter r7 = com.transsion.transfer.androidasync.http.HttpUtil.EndEmitter.P(r7, r8)
            r7.N(r6)
            return r7
        L2e:
            if (r7 != 0) goto L3c
            com.transsion.transfer.androidasync.AsyncServer r7 = r6.a()
            com.transsion.transfer.androidasync.http.HttpUtil$EndEmitter r7 = com.transsion.transfer.androidasync.http.HttpUtil.EndEmitter.P(r7, r0)
            r7.N(r6)
            return r7
        L3c:
            ev.b r7 = new ev.b
            r7.<init>(r2)
            r7.N(r6)
        L44:
            r6 = r7
            goto L6b
        L46:
            java.lang.String r7 = "Transfer-Encoding"
            java.lang.String r7 = r8.c(r7)
            java.lang.String r1 = "chunked"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L5d
            com.transsion.transfer.androidasync.http.filter.ChunkedInputFilter r7 = new com.transsion.transfer.androidasync.http.filter.ChunkedInputFilter
            r7.<init>()
            r7.N(r6)
            goto L44
        L5d:
            if (r9 == 0) goto L6b
            com.transsion.transfer.androidasync.AsyncServer r7 = r6.a()
            com.transsion.transfer.androidasync.http.HttpUtil$EndEmitter r7 = com.transsion.transfer.androidasync.http.HttpUtil.EndEmitter.P(r7, r0)
            r7.N(r6)
            return r7
        L6b:
            java.lang.String r7 = "Content-Encoding"
            java.lang.String r9 = r8.c(r7)
            java.lang.String r0 = "gzip"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L83
            ev.c r7 = new ev.c
            r7.<init>()
            r7.N(r6)
        L81:
            r6 = r7
            goto L98
        L83:
            java.lang.String r9 = "deflate"
            java.lang.String r7 = r8.c(r7)
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L98
            ev.d r7 = new ev.d
            r7.<init>()
            r7.N(r6)
            goto L81
        L98:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.androidasync.http.HttpUtil.c(com.transsion.transfer.androidasync.p, com.transsion.transfer.androidasync.http.Protocol, com.transsion.transfer.androidasync.http.Headers, boolean):com.transsion.transfer.androidasync.p");
    }

    public static boolean d(Protocol protocol, Headers headers) {
        String c11 = headers.c("Connection");
        return c11 == null ? protocol == Protocol.HTTP_1_1 : "keep-alive".equalsIgnoreCase(c11);
    }

    public static boolean e(String str, Headers headers) {
        String c11 = headers.c("Connection");
        return c11 == null ? Protocol.get(str) == Protocol.HTTP_1_1 : "keep-alive".equalsIgnoreCase(c11);
    }
}
