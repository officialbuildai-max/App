package com.cloud.hisavana.sdk.database;

import a4.a;
import android.content.ContentProvider;
import android.content.Context;
import android.content.UriMatcher;
import android.database.SQLException;
import android.net.Uri;
import android.util.Log;
import be.g;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.config.utils.XLogUtil;
import com.cloud.hisavana.abtestkit.db.ABContentProvider;
import com.cloud.hisavana.sdk.common.util.l0;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.v0;
import com.cloud.hisavana.sdk.v3;
import com.cloud.hisavana.sdk.y3;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.google.gson.reflect.TypeToken;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 52\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\f2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ!\u0010\u0015\u001a\u00020\f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ!\u0010\u0017\u001a\u00020\f2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ!\u0010\u0018\u001a\u00020\f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\u00062\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J1\u0010-\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b-\u0010.J;\u0010/\u001a\u00020,2\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010 \u001a\u0004\u0018\u00010\u00042\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/cloud/hisavana/sdk/database/HisavanaContentProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "", "content", "Landroid/net/Uri;", "f", "(Ljava/lang/String;)Landroid/net/Uri;", "", "Lcom/cloud/hisavana/sdk/data/bean/response/AdsDTO;", "adsDTOList", "", CampaignEx.JSON_KEY_AD_K, "(Ljava/util/List;)Z", "", g.f16474b, "(Ljava/util/List;)Ljava/util/List;", "insertList", "i", "updateList", "l", "Lcom/cloud/hisavana/sdk/data/bean/response/ConfigCodeSeatDTO;", "d", "m", "", j.f35620b, "onCreate", "()Z", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", RequestParameters.SUBRESOURCE_DELETE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Lcom/cloud/hisavana/sdk/database/HSRoomDatabase;", "a", "Lcom/cloud/hisavana/sdk/database/HSRoomDatabase;", "database", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HisavanaContentProvider extends ContentProvider {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static String f22476c;

    /* renamed from: d, reason: collision with root package name */
    private static UriMatcher f22477d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HSRoomDatabase database;

    /* renamed from: com.cloud.hisavana.sdk.database.HisavanaContentProvider$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            if (HisavanaContentProvider.f22477d == null) {
                HisavanaContentProvider.f22476c = com.cloud.sdk.commonutil.util.e.a().getPackageName() + ".HisavanaContentProvider";
                HisavanaContentProvider.f22477d = new UriMatcher(-1);
                UriMatcher uriMatcher = HisavanaContentProvider.f22477d;
                if (uriMatcher != null) {
                    uriMatcher.addURI(HisavanaContentProvider.f22476c, XLogUtil.TAG, 100);
                }
                UriMatcher uriMatcher2 = HisavanaContentProvider.f22477d;
                if (uriMatcher2 != null) {
                    uriMatcher2.addURI(HisavanaContentProvider.f22476c, "ad_data", 200);
                }
                ABContentProvider.initUriMatcher(HisavanaContentProvider.f22477d, HisavanaContentProvider.f22476c);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/sdk/database/HisavanaContentProvider$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/cloud/hisavana/sdk/data/bean/response/AdsDTO;", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class b extends TypeToken<List<? extends AdsDTO>> {
        b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/sdk/database/HisavanaContentProvider$c", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/cloud/hisavana/sdk/data/bean/response/ConfigCodeSeatDTO;", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class c extends TypeToken<List<? extends ConfigCodeSeatDTO>> {
        c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/sdk/database/HisavanaContentProvider$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/cloud/hisavana/sdk/data/bean/response/ConfigCodeSeatDTO;", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class d extends TypeToken<List<? extends ConfigCodeSeatDTO>> {
        d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/sdk/database/HisavanaContentProvider$e", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/cloud/hisavana/sdk/data/bean/response/AdsDTO;", "api_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class e extends TypeToken<List<? extends AdsDTO>> {
        e() {
        }
    }

    private final boolean d(List insertList) {
        List l11;
        v0 p02;
        if (e4.c()) {
            e4 b11 = e4.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("insertOrUpdateConfig ");
            sb2.append(insertList != null ? Integer.valueOf(insertList.size()) : null);
            b11.d("HisavanaContentProvider", sb2.toString());
        }
        if (insertList == null || (l11 = CollectionsKt.f0(insertList)) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.isEmpty()) {
            return false;
        }
        try {
            j();
            if (this.database == null) {
                return false;
            }
            List a11 = e1.f22505c.a(l11);
            HSRoomDatabase hSRoomDatabase = this.database;
            if (hSRoomDatabase != null && (p02 = hSRoomDatabase.p0()) != null) {
                p02.c(a11);
            }
            return true;
        } catch (Exception e11) {
            e4.b().e("HisavanaContentProvider", "clearAndInsertConfig fail " + Log.getStackTraceString(e11));
            return false;
        }
    }

    private final Uri f(String content) {
        Uri parse = Uri.parse("content://" + f22476c + '/' + content);
        Intrinsics.g(parse, "parse(...)");
        return parse;
    }

    private final List g(List adsDTOList) {
        ArrayList arrayList;
        v3 h02;
        List<y3> d11;
        if (adsDTOList == null || adsDTOList.isEmpty()) {
            e4.b().d("HisavanaContentProvider", "ad list is null or empty");
            return new ArrayList();
        }
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator it = adsDTOList.iterator();
        String str = "";
        while (it.hasNext()) {
            AdsDTO adsDTO = (AdsDTO) it.next();
            if (adsDTO != null) {
                str = adsDTO.getCodeSeatId();
                Intrinsics.g(str, "getCodeSeatId(...)");
                String adCreativeId = adsDTO.getAdCreativeId();
                Intrinsics.g(adCreativeId, "getAdCreativeId(...)");
                arrayList2.add(adCreativeId);
            }
        }
        if (StringsKt.q0(str) || arrayList2.isEmpty()) {
            return new ArrayList();
        }
        StringBuilder sb2 = new StringBuilder("SELECT * FROM adList_room WHERE codeSeatId = ?  AND ad_creative_id IN (");
        for (String str2 : arrayList2) {
            sb2.append("?,");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb2.append(")");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(str);
        arrayList3.addAll(arrayList2);
        if (e4.c()) {
            e4.b().d("HisavanaContentProvider", "getQueryAdsByAdIds " + ((Object) sb2) + ", " + arrayList3);
        }
        try {
            HSRoomDatabase hSRoomDatabase = this.database;
            if (hSRoomDatabase == null || (h02 = hSRoomDatabase.h0()) == null || (d11 = h02.d(arrayList2)) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(CollectionsKt.v(d11, 10));
                for (y3 y3Var : d11) {
                    AdsDTO adsDTO2 = (AdsDTO) GsonUtil.a(y3Var != null ? y3Var.a() : null, AdsDTO.class);
                    adsDTO2.setTableId(y3Var != null ? y3Var.o() : 0);
                    arrayList.add(adsDTO2);
                }
            }
        } catch (Exception unused) {
            arrayList = new ArrayList();
        }
        return CollectionsKt.U0(arrayList);
    }

    public static final void h() {
        INSTANCE.a();
    }

    private final boolean i(List insertList) {
        List l11;
        v3 h02;
        if (insertList == null || (l11 = CollectionsKt.f0(insertList)) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.isEmpty()) {
            e4.b().d("HisavanaContentProvider", "insertAdsList adList is null or empty");
            return false;
        }
        if (e4.c()) {
            e4.b().d("HisavanaContentProvider", "insertAdsList list: " + l11.size());
        }
        try {
            j();
            if (this.database == null) {
                return false;
            }
            long c11 = l0.c(System.currentTimeMillis());
            Iterator it = l11.iterator();
            while (it.hasNext()) {
                ((AdsDTO) it.next()).setShowDate(c11);
            }
            HSRoomDatabase hSRoomDatabase = this.database;
            if (hSRoomDatabase == null || (h02 = hSRoomDatabase.h0()) == null) {
                return true;
            }
            h02.c(y3.f23195i.a(l11));
            return true;
        } catch (Exception e11) {
            e4.b().e("HisavanaContentProvider", "insert ads fail " + e11.getMessage());
            return false;
        }
    }

    private final void j() {
        if (this.database == null) {
            this.database = HSRoomDatabase.v0();
        }
    }

    private final boolean k(List adsDTOList) {
        List<AdsDTO> l11;
        if (adsDTOList == null || (l11 = CollectionsKt.f0(adsDTOList)) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.isEmpty()) {
            e4.b().d("HisavanaContentProvider", "insertOrUpdateAds list is null or empty");
            return false;
        }
        if (e4.c()) {
            e4.b().d("HisavanaContentProvider", "insertOrUpdateAds list: " + l11.size());
        }
        List g11 = g(l11);
        ArrayList arrayList = new ArrayList();
        if (g11.isEmpty()) {
            return i(adsDTOList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.e(CollectionsKt.v(g11, 10)), 16));
        for (Object obj : g11) {
            AdsDTO adsDTO = (AdsDTO) obj;
            linkedHashMap.put(new Triple(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId(), Boolean.valueOf(adsDTO.isOfflineAd())), obj);
        }
        for (AdsDTO adsDTO2 : l11) {
            AdsDTO adsDTO3 = (AdsDTO) linkedHashMap.get(new Triple(adsDTO2.getAdCreativeId(), adsDTO2.getCodeSeatId(), Boolean.valueOf(adsDTO2.isOfflineAd())));
            if (adsDTO3 != null) {
                adsDTO2.setShowDate(adsDTO3.getShowDate());
                adsDTO2.setShowNum(adsDTO3.getShowNum());
                adsDTO2.setTableId(adsDTO3.getTableId());
                arrayList.add(adsDTO2);
            }
        }
        boolean l12 = l(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : l11) {
            if (!arrayList.contains((AdsDTO) obj2)) {
                arrayList2.add(obj2);
            }
        }
        return l12 && i(arrayList2);
    }

    private final boolean l(List updateList) {
        List l11;
        if (updateList == null || (l11 = CollectionsKt.f0(updateList)) == null) {
            l11 = CollectionsKt.l();
        }
        if (l11.isEmpty()) {
            e4.b().d("HisavanaContentProvider", "updateAdsList list is empty ");
            return false;
        }
        if (e4.c()) {
            e4 b11 = e4.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateAdsList ");
            sb2.append(updateList != null ? Integer.valueOf(updateList.size()) : null);
            b11.d("HisavanaContentProvider", sb2.toString());
        }
        try {
            j();
            HSRoomDatabase hSRoomDatabase = this.database;
            if (hSRoomDatabase == null) {
                return false;
            }
            v3 h02 = hSRoomDatabase.h0();
            Integer valueOf = h02 != null ? Integer.valueOf(h02.a(y3.f23195i.a(l11))) : null;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("updateAdsList: ");
            sb3.append(valueOf);
            return true;
        } catch (Exception e11) {
            e4.b().e("HisavanaContentProvider", "insert Config fail " + Log.getStackTraceString(e11));
            return false;
        }
    }

    private final boolean m(List updateList) {
        List f02;
        v0 p02;
        if (updateList == null || (f02 = CollectionsKt.f0(updateList)) == null || f02.isEmpty()) {
            return false;
        }
        try {
            j();
            if (this.database == null) {
                return false;
            }
            List a11 = e1.f22505c.a(f02);
            HSRoomDatabase hSRoomDatabase = this.database;
            if (hSRoomDatabase == null || (p02 = hSRoomDatabase.p0()) == null) {
                return true;
            }
            p02.a(a11);
            return true;
        } catch (Exception e11) {
            e4.b().e("HisavanaContentProvider", "update config fail" + Log.getStackTraceString(e11));
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.h(uri, "uri");
        e4 b11 = e4.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("delete invalid uri ");
        sb2.append(uri);
        sb2.append(", ");
        sb2.append(selection);
        sb2.append(", ");
        String arrays = Arrays.toString(selectionArgs);
        Intrinsics.g(arrays, "toString(...)");
        sb2.append(arrays);
        b11.d("HisavanaContentProvider", sb2.toString());
        UriMatcher uriMatcher = f22477d;
        if (uriMatcher != null) {
            Intrinsics.e(uriMatcher);
            if (uriMatcher.match(uri) == 200) {
                try {
                    j();
                    UriMatcher uriMatcher2 = f22477d;
                    Integer valueOf = uriMatcher2 != null ? Integer.valueOf(uriMatcher2.match(uri)) : null;
                    if (valueOf != null && valueOf.intValue() == 100) {
                        v0 p02 = HSRoomDatabase.v0().p0();
                        if (selection == null) {
                            selection = "";
                        }
                        p02.b(new a(selection, selectionArgs));
                        return 0;
                    }
                    if (valueOf != null && valueOf.intValue() == 200) {
                        v3 h02 = HSRoomDatabase.v0().h0();
                        if (selection == null) {
                            selection = "";
                        }
                        h02.b(new a(selection, selectionArgs));
                        return 0;
                    }
                    if (valueOf.intValue() == 300) {
                        return ABContentProvider.delete(uri, selection, selectionArgs);
                    }
                    if (valueOf == null || valueOf.intValue() != 400) {
                        return 0;
                    }
                    return ABContentProvider.delete(uri, selection, selectionArgs);
                } catch (SQLException e11) {
                    e4.b().e("HisavanaContentProvider", "delete sqlException: " + e11.getMessage());
                } catch (Exception e12) {
                    e4.b().e("HisavanaContentProvider", "delete exception: " + e12.getMessage());
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Intrinsics.h(uri, "uri");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
    
        if (r2.intValue() != 400) goto L51;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri insert(android.net.Uri r6, android.content.ContentValues r7) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.database.HisavanaContentProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            Objects.requireNonNull(context);
            com.cloud.sdk.commonutil.util.e.i(context);
            return false;
        } catch (Exception e11) {
            e4.b().e("HisavanaContentProvider", "HSCoreUtil set context failed " + Log.getStackTraceString(e11));
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return null;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.database.Cursor query(android.net.Uri r6, java.lang.String[] r7, java.lang.String r8, java.lang.String[] r9, java.lang.String r10) {
        /*
            r5 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.h(r6, r0)
            r0 = 0
            r5.j()     // Catch: java.lang.Exception -> L1b
            com.cloud.hisavana.sdk.database.HSRoomDatabase r1 = r5.database     // Catch: java.lang.Exception -> L1b
            if (r1 != 0) goto Le
            return r0
        Le:
            android.content.UriMatcher r1 = com.cloud.hisavana.sdk.database.HisavanaContentProvider.f22477d     // Catch: java.lang.Exception -> L1b
            if (r1 == 0) goto L1e
            int r1 = r1.match(r6)     // Catch: java.lang.Exception -> L1b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L1b
            goto L1f
        L1b:
            r6 = move-exception
            goto L8a
        L1e:
            r1 = r0
        L1f:
            java.lang.String r2 = ""
            if (r1 != 0) goto L24
            goto L42
        L24:
            int r3 = r1.intValue()     // Catch: java.lang.Exception -> L1b
            r4 = 100
            if (r3 != r4) goto L42
            com.cloud.hisavana.sdk.database.HSRoomDatabase r6 = com.cloud.hisavana.sdk.database.HSRoomDatabase.v0()     // Catch: java.lang.Exception -> L1b
            com.cloud.hisavana.sdk.v0 r6 = r6.p0()     // Catch: java.lang.Exception -> L1b
            a4.a r7 = new a4.a     // Catch: java.lang.Exception -> L1b
            if (r8 != 0) goto L39
            r8 = r2
        L39:
            r7.<init>(r8, r9)     // Catch: java.lang.Exception -> L1b
            android.database.Cursor r6 = r6.a(r7)     // Catch: java.lang.Exception -> L1b
        L40:
            r0 = r6
            goto L97
        L42:
            if (r1 != 0) goto L45
            goto L62
        L45:
            int r3 = r1.intValue()     // Catch: java.lang.Exception -> L1b
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L62
            com.cloud.hisavana.sdk.database.HSRoomDatabase r6 = com.cloud.hisavana.sdk.database.HSRoomDatabase.v0()     // Catch: java.lang.Exception -> L1b
            com.cloud.hisavana.sdk.v3 r6 = r6.h0()     // Catch: java.lang.Exception -> L1b
            a4.a r7 = new a4.a     // Catch: java.lang.Exception -> L1b
            if (r8 != 0) goto L5a
            r8 = r2
        L5a:
            r7.<init>(r8, r9)     // Catch: java.lang.Exception -> L1b
            android.database.Cursor r6 = r6.a(r7)     // Catch: java.lang.Exception -> L1b
            goto L40
        L62:
            if (r1 != 0) goto L65
            goto L6e
        L65:
            int r2 = r1.intValue()     // Catch: java.lang.Exception -> L1b
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 != r3) goto L6e
            goto L85
        L6e:
            if (r1 != 0) goto L71
            goto L7a
        L71:
            int r2 = r1.intValue()     // Catch: java.lang.Exception -> L1b
            r3 = 400(0x190, float:5.6E-43)
            if (r2 != r3) goto L7a
            goto L85
        L7a:
            if (r1 != 0) goto L7d
            goto L97
        L7d:
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L1b
            r2 = 500(0x1f4, float:7.0E-43)
            if (r1 != r2) goto L97
        L85:
            android.database.Cursor r6 = com.cloud.hisavana.abtestkit.db.ABContentProvider.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L1b
            return r6
        L8a:
            com.cloud.hisavana.sdk.e4 r7 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r6 = android.util.Log.getStackTraceString(r6)
            java.lang.String r8 = "HisavanaContentProvider"
            r7.e(r8, r6)
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.database.HisavanaContentProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
    
        if (r0.intValue() != 400) goto L45;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int update(android.net.Uri r8, android.content.ContentValues r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.database.HisavanaContentProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
