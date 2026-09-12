package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.node.l0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.style.p;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0014\u0012\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'H\u0096\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0011H\u0016¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00106R\"\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010;R*\u0010\u0019\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u00104R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "Landroidx/compose/ui/node/l0;", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/text/AnnotatedString;", MimeTypes.BASE_TYPE_TEXT, "Landroidx/compose/ui/text/d0;", TtmlNode.TAG_STYLE, "Landroidx/compose/ui/text/font/h$b;", "fontFamilyResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/text/z;", "", "onTextLayout", "Landroidx/compose/ui/text/style/p;", "overflow", "", "softWrap", "", "maxLines", "minLines", "", "Landroidx/compose/ui/text/AnnotatedString$c;", "Landroidx/compose/ui/text/t;", "placeholders", "Ly/i;", "onPlaceholderLayout", "Landroidx/compose/foundation/text/modifiers/h;", "selectionController", "Landroidx/compose/ui/graphics/x1;", TtmlNode.ATTR_TTS_COLOR, "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$a;", "onShowTranslation", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/d0;Landroidx/compose/ui/text/font/h$b;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/h;Landroidx/compose/ui/graphics/x1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", j.f35620b, "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "node", CampaignEx.JSON_KEY_AD_K, "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;)V", "", OfflineConstantsKt.OFFLINE_DOWNLOAD_CHANNEL_MODE_OTHER, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroidx/compose/ui/text/AnnotatedString;", "c", "Landroidx/compose/ui/text/d0;", "d", "Landroidx/compose/ui/text/font/h$b;", "e", "Lkotlin/jvm/functions/Function1;", "f", "I", be.g.f16474b, "Z", "h", "i", "Ljava/util/List;", "l", "Landroidx/compose/foundation/text/modifiers/h;", "m", "Landroidx/compose/ui/graphics/x1;", "n", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes.dex */
public final class TextAnnotatedStringElement extends l0 {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AnnotatedString text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final d0 style;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final h.b fontFamilyResolver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function1 onTextLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int overflow;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean softWrap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int maxLines;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int minLines;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final List placeholders;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Function1 onPlaceholderLayout;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final h selectionController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final x1 color;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Function1 onShowTranslation;

    private TextAnnotatedStringElement(AnnotatedString annotatedString, d0 d0Var, h.b bVar, Function1 function1, int i11, boolean z10, int i12, int i13, List list, Function1 function12, h hVar, x1 x1Var, Function1 function13) {
        this.text = annotatedString;
        this.style = d0Var;
        this.fontFamilyResolver = bVar;
        this.onTextLayout = function1;
        this.overflow = i11;
        this.softWrap = z10;
        this.maxLines = i12;
        this.minLines = i13;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.color = x1Var;
        this.onShowTranslation = function13;
    }

    public /* synthetic */ TextAnnotatedStringElement(AnnotatedString annotatedString, d0 d0Var, h.b bVar, Function1 function1, int i11, boolean z10, int i12, int i13, List list, Function1 function12, h hVar, x1 x1Var, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, d0Var, bVar, function1, i11, z10, i12, i13, list, function12, hVar, x1Var, function13);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) other;
        return Intrinsics.c(this.color, textAnnotatedStringElement.color) && Intrinsics.c(this.text, textAnnotatedStringElement.text) && Intrinsics.c(this.style, textAnnotatedStringElement.style) && Intrinsics.c(this.placeholders, textAnnotatedStringElement.placeholders) && Intrinsics.c(this.fontFamilyResolver, textAnnotatedStringElement.fontFamilyResolver) && this.onTextLayout == textAnnotatedStringElement.onTextLayout && this.onShowTranslation == textAnnotatedStringElement.onShowTranslation && p.e(this.overflow, textAnnotatedStringElement.overflow) && this.softWrap == textAnnotatedStringElement.softWrap && this.maxLines == textAnnotatedStringElement.maxLines && this.minLines == textAnnotatedStringElement.minLines && this.onPlaceholderLayout == textAnnotatedStringElement.onPlaceholderLayout && Intrinsics.c(this.selectionController, textAnnotatedStringElement.selectionController);
    }

    public int hashCode() {
        int hashCode = ((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31;
        Function1 function1 = this.onTextLayout;
        int hashCode2 = (((((((((hashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + p.f(this.overflow)) * 31) + androidx.compose.foundation.e.a(this.softWrap)) * 31) + this.maxLines) * 31) + this.minLines) * 31;
        List list = this.placeholders;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Function1 function12 = this.onPlaceholderLayout;
        int hashCode4 = (((hashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31) + 0) * 31;
        x1 x1Var = this.color;
        int hashCode5 = (hashCode4 + (x1Var != null ? x1Var.hashCode() : 0)) * 31;
        Function1 function13 = this.onShowTranslation;
        return hashCode5 + (function13 != null ? function13.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public TextAnnotatedStringNode a() {
        return new TextAnnotatedStringNode(this.text, this.style, this.fontFamilyResolver, this.onTextLayout, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.onPlaceholderLayout, this.selectionController, this.color, this.onShowTranslation, null);
    }

    @Override // androidx.compose.ui.node.l0
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void i(TextAnnotatedStringNode node) {
        node.K1(node.T1(this.color, this.style), node.V1(this.text), node.U1(this.style, this.placeholders, this.minLines, this.maxLines, this.softWrap, this.fontFamilyResolver, this.overflow), node.S1(this.onTextLayout, this.onPlaceholderLayout, this.selectionController, this.onShowTranslation));
    }
}
