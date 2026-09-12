package com.transsion.baselib.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.meituan.android.walle.ChannelReader;
import com.transsion.core.utils.ToastUtil;
import com.transsion.search_pugc.fragment.hot.SearchHotFragment;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f43318a = new b();

    private b() {
    }

    private final String a(String str) {
        return (str == null || str.length() == 0) ? str : Intrinsics.c(str, "/search/activity/search_manager") ? SearchHotFragment.PAGE_NAME : Intrinsics.c(str, "/download/panel_activity") ? "/download/ugc_my_downloads" : str;
    }

    private final Uri b(Uri uri) {
        return uri;
    }

    private final boolean f(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return CollectionsKt.o("/rank/all", "/home/movieFilter", "/home/playlist", "/movie/staff", "/home/category").contains(str);
    }

    public final ReferrerBean c(Uri uri) {
        String queryParameter;
        String uri2;
        ReferrerBean referrerBean = new ReferrerBean(null, null, null, null, null, 31, null);
        if (StringsKt.c0(String.valueOf(uri != null ? uri.getPath() : null), "/share", false, 2, null)) {
            referrerBean.setUtmSource("share");
        } else {
            if (uri != null && (uri2 = uri.toString()) != null && StringsKt.c0(uri2, "utm_source", false, 2, null)) {
                Uri parse = Uri.parse(UrlUtils.QUESTION_MARK + uri);
                String valueOf = String.valueOf(parse.getQueryParameter("utm_source"));
                referrerBean.setUtmContent(parse.getQueryParameter("utm_content"));
                referrerBean.setUtmCampaign(parse.getQueryParameter("utm_campaign"));
                if (!TextUtils.isEmpty(valueOf)) {
                    referrerBean.setUtmSource(valueOf);
                    return referrerBean;
                }
            }
            String str = "";
            if (!TextUtils.isEmpty(uri != null ? uri.getQueryParameter("utm_source") : null) ? !(uri == null || (queryParameter = uri.getQueryParameter("utm_source")) == null) : !(uri == null || (queryParameter = uri.getQueryParameter(ChannelReader.CHANNEL_KEY)) == null)) {
                str = queryParameter;
            }
            referrerBean.setUtmSource(str);
            referrerBean.setUtmContent(uri != null ? uri.getQueryParameter("utm_content") : null);
            referrerBean.setUtmCampaign(uri != null ? uri.getQueryParameter("utm_campaign") : null);
        }
        return referrerBean;
    }

    public final ReferrerBean d(String str) {
        return (str == null || str.length() == 0) ? new ReferrerBean(null, null, null, null, null, 31, null) : c(Uri.parse(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.c(r4 != null ? r4.getScheme() : null, "http") != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.net.Uri r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L8
            java.lang.String r1 = r4.getScheme()
            goto L9
        L8:
            r1 = r0
        L9:
            java.lang.String r2 = "https"
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)
            if (r1 != 0) goto L1f
            if (r4 == 0) goto L17
            java.lang.String r0 = r4.getScheme()
        L17:
            java.lang.String r1 = "http"
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r1)
            if (r0 == 0) goto L2b
        L1f:
            java.lang.String r4 = r4.getQuery()
            boolean r4 = com.google.common.base.p.b(r4)
            if (r4 == 0) goto L2b
            r4 = 1
            goto L2c
        L2b:
            r4 = 0
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.baselib.helper.b.e(android.net.Uri):boolean");
    }

    public final Uri g(Uri uri) {
        int i11;
        String str;
        List S0;
        String str2 = null;
        if (uri == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String queryParameter = uri.getQueryParameter(NativeComponentConstants.KEY_COMPONENT_TYPE);
            if (queryParameter == null) {
                queryParameter = "";
            }
            if (queryParameter.length() > 0) {
                if (ak.g.f714a.b()) {
                    b bVar = f43318a;
                    if (bVar.f(queryParameter)) {
                        return new Uri.Builder().encodedPath("/main/tab").build();
                    }
                    String a11 = bVar.a(queryParameter);
                    if (!Intrinsics.c(a11, queryParameter)) {
                        Uri.Builder clearQuery = uri.buildUpon().path(a11).clearQuery();
                        Set<String> queryParameterNames = uri.getQueryParameterNames();
                        Intrinsics.g(queryParameterNames, "getQueryParameterNames(...)");
                        for (String str3 : queryParameterNames) {
                            if (Intrinsics.c(str3, NativeComponentConstants.KEY_COMPONENT_TYPE)) {
                                clearQuery.appendQueryParameter(NativeComponentConstants.KEY_COMPONENT_TYPE, a11);
                            } else {
                                String queryParameter2 = uri.getQueryParameter(str3);
                                if (queryParameter2 != null) {
                                    clearQuery.appendQueryParameter(str3, queryParameter2);
                                }
                            }
                        }
                        Uri build = clearQuery.build();
                        Uri b11 = f43318a.b(build);
                        return b11 == null ? build : b11;
                    }
                    if (Intrinsics.c(queryParameter, "/movie/detail")) {
                        String queryParameter3 = uri.getQueryParameter("id");
                        Uri.Builder clearQuery2 = uri.buildUpon().path("/ugc_video/detail").clearQuery();
                        Set<String> queryParameterNames2 = uri.getQueryParameterNames();
                        Intrinsics.g(queryParameterNames2, "getQueryParameterNames(...)");
                        for (String str4 : queryParameterNames2) {
                            if (Intrinsics.c(str4, "id")) {
                                if (queryParameter3 != null) {
                                    clearQuery2.appendQueryParameter("subject_id", queryParameter3);
                                }
                            } else if (Intrinsics.c(str4, NativeComponentConstants.KEY_COMPONENT_TYPE)) {
                                clearQuery2.appendQueryParameter(NativeComponentConstants.KEY_COMPONENT_TYPE, "/ugc_video/detail");
                            } else {
                                String queryParameter4 = uri.getQueryParameter(str4);
                                if (queryParameter4 != null) {
                                    clearQuery2.appendQueryParameter(str4, queryParameter4);
                                }
                            }
                        }
                        if (queryParameter3 == null) {
                            String path = uri.getPath();
                            if (path != null && (S0 = StringsKt.S0(path, new String[]{"/"}, false, 0, 6, null)) != null) {
                                str2 = (String) CollectionsKt.v0(S0);
                            }
                            if (str2 != null) {
                                clearQuery2.appendQueryParameter("subject_id", str2);
                            }
                        }
                        return clearQuery2.build();
                    }
                }
                Uri build2 = uri.buildUpon().path(queryParameter).build();
                Uri b12 = f43318a.b(build2);
                return b12 == null ? build2 : b12;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("subject", "/movie/detail");
            hashMap.put("post", "/post/detail");
            String uri2 = uri.toString();
            Intrinsics.g(uri2, "toString(...)");
            if (TextUtils.isEmpty(uri2)) {
                i11 = 0;
            } else {
                i11 = 0;
                List S02 = StringsKt.S0(uri2, new String[]{"-"}, false, 0, 6, null);
                if (S02.size() >= 2) {
                    String str5 = (String) hashMap.get(S02.get(0));
                    String str6 = (String) S02.get(1);
                    if (str5 != null) {
                        if (ak.g.f714a.b()) {
                            b bVar2 = f43318a;
                            if (bVar2.f(str5)) {
                                return new Uri.Builder().encodedPath("/main/tab").build();
                            }
                            String a12 = bVar2.a(str5);
                            if (a12 != null && !Intrinsics.c(a12, str5)) {
                                return new Uri.Builder().encodedPath(a12).encodedQuery("id=" + str6).build();
                            }
                            if (Intrinsics.c(str5, "/movie/detail")) {
                                return new Uri.Builder().encodedPath("/ugc_video/detail").encodedQuery("subject_id=" + str6).build();
                            }
                        }
                        return new Uri.Builder().encodedPath(str5).encodedQuery("id=" + str6).build();
                    }
                }
            }
            String path2 = uri.getPath();
            String str7 = path2 == null ? "" : path2;
            for (int i12 = i11; i12 < str7.length(); i12++) {
                if (str7.charAt(i12) == '/') {
                    i11++;
                }
            }
            if (i11 < 2) {
                return null;
            }
            if (ak.g.f714a.b()) {
                b bVar3 = f43318a;
                if (bVar3.f(str7)) {
                    return new Uri.Builder().encodedPath("/main/tab").build();
                }
                String a13 = bVar3.a(str7);
                if (!Intrinsics.c(a13, str7)) {
                    Uri.Builder path3 = uri.buildUpon().path(a13);
                    Uri b13 = bVar3.b(path3.build());
                    return b13 == null ? path3.build() : b13;
                }
                if (Intrinsics.c(str7, "/movie/detail")) {
                    String queryParameter5 = uri.getQueryParameter("id");
                    Uri.Builder clearQuery3 = uri.buildUpon().path("/ugc_video/detail").clearQuery();
                    Set<String> queryParameterNames3 = uri.getQueryParameterNames();
                    Intrinsics.g(queryParameterNames3, "getQueryParameterNames(...)");
                    for (String str8 : queryParameterNames3) {
                        if (!Intrinsics.c(str8, "id")) {
                            String queryParameter6 = uri.getQueryParameter(str8);
                            if (queryParameter6 != null) {
                                clearQuery3.appendQueryParameter(str8, queryParameter6);
                            }
                        } else if (queryParameter5 != null) {
                            clearQuery3.appendQueryParameter("subject_id", queryParameter5);
                        }
                    }
                    if (queryParameter5 == null && (str = (String) CollectionsKt.v0(StringsKt.S0(str7, new String[]{"/"}, false, 0, 6, null))) != null) {
                        clearQuery3.appendQueryParameter("subject_id", str);
                    }
                    return clearQuery3.build();
                }
            }
            Uri b14 = f43318a.b(uri);
            return b14 == null ? uri : b14;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            if (Result.m1188exceptionOrNullimpl(Result.m1185constructorimpl(ResultKt.a(th2))) != null) {
                ToastUtil.f("请升级最新版本");
            }
            return uri;
        }
    }
}
