package com.transsion.shorttv.bean;

import androidx.annotation.Keep;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.annotations.SerializedName;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import js.a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Keep
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0003\b¾\u0001\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002Bù\u0005\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u001b\u0012\b\b\u0002\u0010'\u001a\u00020\u001b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010.\u001a\u00020\u001b\u0012\b\b\u0002\u0010/\u001a\u00020\u001b\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\u0005\u0012\b\b\u0002\u00105\u001a\u00020\u001b\u0012\b\b\u0002\u00106\u001a\u00020\u001b\u0012\b\b\u0002\u00107\u001a\u00020\u0019\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u0010\u0012\b\b\u0002\u0010;\u001a\u00020\u0019\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 \u0012\b\b\u0002\u0010=\u001a\u00020\u0005\u0012\b\b\u0002\u0010>\u001a\u00020\u001b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010@\u001a\u00020\u0005\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010 \u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010G\u001a\u00020\u001b\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\u0005\u0012\b\b\u0002\u0010L\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u0012\b\b\u0002\u0010N\u001a\u00020\u0005\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050R¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u001b¢\u0006\u0004\bV\u0010WJ\r\u0010X\u001a\u00020\u001b¢\u0006\u0004\bX\u0010WJ\r\u0010Y\u001a\u00020\u0000¢\u0006\u0004\bY\u0010ZJ\r\u0010[\u001a\u00020\u0003¢\u0006\u0004\b[\u0010\\R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010]\u001a\u0004\b^\u0010\\\"\u0004\b_\u0010`R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010]\u001a\u0004\bf\u0010\\\"\u0004\bg\u0010`R$\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010]\u001a\u0004\bh\u0010\\\"\u0004\bi\u0010`R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010]\u001a\u0004\bo\u0010\\\"\u0004\bp\u0010`R$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010]\u001a\u0004\bq\u0010\\\"\u0004\br\u0010`R$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010]\u001a\u0004\bs\u0010\\\"\u0004\bt\u0010`R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010a\u001a\u0004\bu\u0010c\"\u0004\bv\u0010eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010]\u001a\u0004\bw\u0010\\\"\u0004\bx\u0010`R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R$\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010]\u001a\u0004\b~\u0010\\\"\u0004\b\u007f\u0010`R&\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0013\u0010]\u001a\u0005\b\u0080\u0001\u0010\\\"\u0005\b\u0081\u0001\u0010`R&\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0014\u0010]\u001a\u0005\b\u0082\u0001\u0010\\\"\u0005\b\u0083\u0001\u0010`R&\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0015\u0010]\u001a\u0005\b\u0084\u0001\u0010\\\"\u0005\b\u0085\u0001\u0010`R&\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0016\u0010a\u001a\u0005\b\u0086\u0001\u0010c\"\u0005\b\u0087\u0001\u0010eR,\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u0018\u0010y\u001a\u0005\b\u0088\u0001\u0010{\"\u0005\b\u0089\u0001\u0010}R)\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u001a\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R)\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u001c\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R&\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u001d\u0010]\u001a\u0005\b\u0094\u0001\u0010\\\"\u0005\b\u0095\u0001\u0010`R1\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u001f\n\u0005\b\u001f\u0010\u0096\u0001\u0012\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R4\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0004\b\"\u0010y\u0012\u0006\b\u009f\u0001\u0010\u009c\u0001\u001a\u0005\b\u009d\u0001\u0010{\"\u0005\b\u009e\u0001\u0010}R&\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b#\u0010j\u001a\u0005\b \u0001\u0010l\"\u0005\b¡\u0001\u0010nR)\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b%\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R&\u0010&\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b&\u0010§\u0001\u001a\u0005\b¨\u0001\u0010W\"\u0006\b©\u0001\u0010ª\u0001R&\u0010'\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b'\u0010§\u0001\u001a\u0005\b«\u0001\u0010W\"\u0006\b¬\u0001\u0010ª\u0001R)\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b)\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R&\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b*\u0010]\u001a\u0005\b²\u0001\u0010\\\"\u0005\b³\u0001\u0010`R)\u0010+\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b+\u0010\u008a\u0001\u001a\u0006\b´\u0001\u0010\u008c\u0001\"\u0006\bµ\u0001\u0010\u008e\u0001R&\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b,\u0010]\u001a\u0005\b¶\u0001\u0010\\\"\u0005\b·\u0001\u0010`R&\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b-\u0010]\u001a\u0005\b¸\u0001\u0010\\\"\u0005\b¹\u0001\u0010`R&\u0010.\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b.\u0010§\u0001\u001a\u0005\bº\u0001\u0010W\"\u0006\b»\u0001\u0010ª\u0001R%\u0010/\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b/\u0010§\u0001\u001a\u0004\b/\u0010W\"\u0006\b¼\u0001\u0010ª\u0001R)\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b1\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R)\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b3\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R'\u00104\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b4\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R&\u00105\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b5\u0010§\u0001\u001a\u0005\bÌ\u0001\u0010W\"\u0006\bÍ\u0001\u0010ª\u0001R&\u00106\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b6\u0010§\u0001\u001a\u0005\bÎ\u0001\u0010W\"\u0006\bÏ\u0001\u0010ª\u0001R'\u00107\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b7\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R&\u00108\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b8\u0010]\u001a\u0005\bÕ\u0001\u0010\\\"\u0005\bÖ\u0001\u0010`R,\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b:\u0010y\u001a\u0005\b×\u0001\u0010{\"\u0005\bØ\u0001\u0010}R'\u0010;\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b;\u0010Ð\u0001\u001a\u0006\bÙ\u0001\u0010Ò\u0001\"\u0006\bÚ\u0001\u0010Ô\u0001R,\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b<\u0010y\u001a\u0005\bÛ\u0001\u0010{\"\u0005\bÜ\u0001\u0010}R'\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b=\u0010Ç\u0001\u001a\u0006\bÝ\u0001\u0010É\u0001\"\u0006\bÞ\u0001\u0010Ë\u0001R&\u0010>\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b>\u0010§\u0001\u001a\u0005\bß\u0001\u0010W\"\u0006\bà\u0001\u0010ª\u0001R&\u0010?\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b?\u0010a\u001a\u0005\bá\u0001\u0010c\"\u0005\bâ\u0001\u0010eR'\u0010@\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b@\u0010Ç\u0001\u001a\u0006\bã\u0001\u0010É\u0001\"\u0006\bä\u0001\u0010Ë\u0001R&\u0010A\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bA\u0010]\u001a\u0005\bå\u0001\u0010\\\"\u0005\bæ\u0001\u0010`R,\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bC\u0010y\u001a\u0005\bç\u0001\u0010{\"\u0005\bè\u0001\u0010}R&\u0010D\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bD\u0010]\u001a\u0005\bé\u0001\u0010\\\"\u0005\bê\u0001\u0010`R&\u0010E\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bE\u0010]\u001a\u0005\bë\u0001\u0010\\\"\u0005\bì\u0001\u0010`R)\u0010F\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bF\u0010\u008a\u0001\u001a\u0006\bí\u0001\u0010\u008c\u0001\"\u0006\bî\u0001\u0010\u008e\u0001R&\u0010G\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bG\u0010§\u0001\u001a\u0005\bï\u0001\u0010W\"\u0006\bð\u0001\u0010ª\u0001R&\u0010H\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bH\u0010a\u001a\u0005\bñ\u0001\u0010c\"\u0005\bò\u0001\u0010eR)\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bJ\u0010ó\u0001\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R'\u0010K\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bK\u0010Ç\u0001\u001a\u0006\bø\u0001\u0010É\u0001\"\u0006\bù\u0001\u0010Ë\u0001R'\u0010L\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bL\u0010Ç\u0001\u001a\u0006\bú\u0001\u0010É\u0001\"\u0006\bû\u0001\u0010Ë\u0001R*\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bM\u0010y\u001a\u0005\bü\u0001\u0010{\"\u0005\bý\u0001\u0010}R&\u0010N\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bN\u0010Ç\u0001\u001a\u0005\bN\u0010É\u0001\"\u0006\bþ\u0001\u0010Ë\u0001R)\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bP\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R'\u0010Q\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bQ\u0010Ç\u0001\u001a\u0006\b\u0084\u0002\u0010É\u0001\"\u0006\b\u0085\u0002\u0010Ë\u0001R-\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050R8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bS\u0010\u0086\u0002\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002\"\u0006\b\u0089\u0002\u0010\u008a\u0002R\u0016\u0010\u008d\u0002\u001a\u0004\u0018\u00010!8F¢\u0006\b\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002R\u0014\u0010\u008f\u0002\u001a\u00020\u00198F¢\u0006\b\u001a\u0006\b\u008e\u0002\u0010Ò\u0001¨\u0006\u0090\u0002"}, d2 = {"Lcom/transsion/shorttv/bean/Subject;", "Ljs/a;", "Ljava/io/Serializable;", "", "subjectId", "", "subjectType", CampaignEx.JSON_KEY_TITLE, "countryName", "Lcom/transsion/shorttv/bean/Cover;", "cover", "releaseDate", TrackingKey.DESCRIPTION, "duration", "durationSeconds", "genre", "", "tags", "tag", "imdbRate", TmcConstants.KEY_LANGUAGE, "mySeeTime", "seenStatus", "Lcom/transsion/shorttv/bean/Staff;", "staffList", "", "wantToSeeCount", "", "hasResource", "ops", "Lcom/transsion/shorttv/bean/SubjectDl;", "download", "", "Lcom/transsion/shorttv/bean/ResourceDetectors;", "resourceDetectors", "stills", "Lcom/transsion/shorttv/bean/Trailer;", "trailer", "series", "correlation", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "nonAdDelegate", "postTitle", "viewers", "contentRating", "category", "builtIn", "isCache", "Lcom/transsion/shorttv/bean/ShortTVItem;", "shortTVFirstEp", "Lcom/transsion/shorttv/bean/ShortTVFavInfo;", "shortTVFavInfo", "totalEpisode", "loadCoverSuccess", "coverCache", "loadCoverDuration", "aka", "Lcom/transsion/shorttv/bean/ExplainBean;", "explains", "totalSize", "unlockedEps", "coinPerEp", "deleted", "seNum", "season", "subtitles", "Lcom/transsion/shorttv/bean/DubsInfo;", "dubs", "corner", "restrictLevel", "appointmentCnt", "showTitle", "likeStatus", "Lcom/transsion/shorttv/bean/PlayUrl;", "playUrl", "miniTvType", "needPaid", "unlockType", "isPaid", "Lcom/transsion/shorttv/bean/SkuInfo;", "skuInfo", "unlockFrom", "", "adUnlockedEps", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/shorttv/bean/Cover;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/transsion/shorttv/bean/SubjectDl;Ljava/util/List;Lcom/transsion/shorttv/bean/Cover;Lcom/transsion/shorttv/bean/Trailer;ZZLcom/transsion/ad/bidding/nativead/BiddingNativeManager;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZZLcom/transsion/shorttv/bean/ShortTVItem;Lcom/transsion/shorttv/bean/ShortTVFavInfo;IZZJLjava/lang/String;Ljava/util/List;JLjava/util/List;IZLjava/lang/Integer;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ZLjava/lang/Integer;Lcom/transsion/shorttv/bean/PlayUrl;IILjava/util/List;ILcom/transsion/shorttv/bean/SkuInfo;ILjava/util/Set;)V", "isSeries", "()Z", "isShortTV", "copyData", "()Lcom/transsion/shorttv/bean/Subject;", "toStringAboutLock", "()Ljava/lang/String;", "Ljava/lang/String;", "getSubjectId", "setSubjectId", "(Ljava/lang/String;)V", "Ljava/lang/Integer;", "getSubjectType", "()Ljava/lang/Integer;", "setSubjectType", "(Ljava/lang/Integer;)V", "getTitle", "setTitle", "getCountryName", "setCountryName", "Lcom/transsion/shorttv/bean/Cover;", "getCover", "()Lcom/transsion/shorttv/bean/Cover;", "setCover", "(Lcom/transsion/shorttv/bean/Cover;)V", "getReleaseDate", "setReleaseDate", "getDescription", "setDescription", "getDuration", "setDuration", "getDurationSeconds", "setDurationSeconds", "getGenre", "setGenre", "Ljava/util/List;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTag", "setTag", "getImdbRate", "setImdbRate", "getLanguage", "setLanguage", "getMySeeTime", "setMySeeTime", "getSeenStatus", "setSeenStatus", "getStaffList", "setStaffList", "Ljava/lang/Long;", "getWantToSeeCount", "()Ljava/lang/Long;", "setWantToSeeCount", "(Ljava/lang/Long;)V", "Ljava/lang/Boolean;", "getHasResource", "()Ljava/lang/Boolean;", "setHasResource", "(Ljava/lang/Boolean;)V", "getOps", "setOps", "Lcom/transsion/shorttv/bean/SubjectDl;", "getDownload", "()Lcom/transsion/shorttv/bean/SubjectDl;", "setDownload", "(Lcom/transsion/shorttv/bean/SubjectDl;)V", "getDownload$annotations", "()V", "getResourceDetectors", "setResourceDetectors", "getResourceDetectors$annotations", "getStills", "setStills", "Lcom/transsion/shorttv/bean/Trailer;", "getTrailer", "()Lcom/transsion/shorttv/bean/Trailer;", "setTrailer", "(Lcom/transsion/shorttv/bean/Trailer;)V", "Z", "getSeries", "setSeries", "(Z)V", "getCorrelation", "setCorrelation", "Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "getNonAdDelegate", "()Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;", "setNonAdDelegate", "(Lcom/transsion/ad/bidding/nativead/BiddingNativeManager;)V", "getPostTitle", "setPostTitle", "getViewers", "setViewers", "getContentRating", "setContentRating", "getCategory", "setCategory", "getBuiltIn", "setBuiltIn", "setCache", "Lcom/transsion/shorttv/bean/ShortTVItem;", "getShortTVFirstEp", "()Lcom/transsion/shorttv/bean/ShortTVItem;", "setShortTVFirstEp", "(Lcom/transsion/shorttv/bean/ShortTVItem;)V", "Lcom/transsion/shorttv/bean/ShortTVFavInfo;", "getShortTVFavInfo", "()Lcom/transsion/shorttv/bean/ShortTVFavInfo;", "setShortTVFavInfo", "(Lcom/transsion/shorttv/bean/ShortTVFavInfo;)V", "I", "getTotalEpisode", "()I", "setTotalEpisode", "(I)V", "getLoadCoverSuccess", "setLoadCoverSuccess", "getCoverCache", "setCoverCache", "J", "getLoadCoverDuration", "()J", "setLoadCoverDuration", "(J)V", "getAka", "setAka", "getExplains", "setExplains", "getTotalSize", "setTotalSize", "getUnlockedEps", "setUnlockedEps", "getCoinPerEp", "setCoinPerEp", "getDeleted", "setDeleted", "getSeNum", "setSeNum", "getSeason", "setSeason", "getSubtitles", "setSubtitles", "getDubs", "setDubs", "getCorner", "setCorner", "getRestrictLevel", "setRestrictLevel", "getAppointmentCnt", "setAppointmentCnt", "getShowTitle", "setShowTitle", "getLikeStatus", "setLikeStatus", "Lcom/transsion/shorttv/bean/PlayUrl;", "getPlayUrl", "()Lcom/transsion/shorttv/bean/PlayUrl;", "setPlayUrl", "(Lcom/transsion/shorttv/bean/PlayUrl;)V", "getMiniTvType", "setMiniTvType", "getNeedPaid", "setNeedPaid", "getUnlockType", "setUnlockType", "setPaid", "Lcom/transsion/shorttv/bean/SkuInfo;", "getSkuInfo", "()Lcom/transsion/shorttv/bean/SkuInfo;", "setSkuInfo", "(Lcom/transsion/shorttv/bean/SkuInfo;)V", "getUnlockFrom", "setUnlockFrom", "Ljava/util/Set;", "getAdUnlockedEps", "()Ljava/util/Set;", "setAdUnlockedEps", "(Ljava/util/Set;)V", "getResourceDetector", "()Lcom/transsion/shorttv/bean/ResourceDetectors;", "resourceDetector", "getResourceAboutDuration", "resourceAboutDuration", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public class Subject extends a implements Serializable {
    private Set<Integer> adUnlockedEps;
    private String aka;

    @SerializedName("appointmentCnt")
    private Long appointmentCnt;
    private boolean builtIn;

    @SerializedName("category")
    private String category;
    private int coinPerEp;

    @SerializedName("contentRating")
    private String contentRating;

    @SerializedName("corner")
    private String corner;
    private transient boolean correlation;

    @SerializedName("countryName")
    private String countryName;

    @SerializedName("cover")
    private Cover cover;
    private transient boolean coverCache;
    private transient boolean deleted;

    @SerializedName(TrackingKey.DESCRIPTION)
    private String description;

    @SerializedName("dl")
    private SubjectDl download;
    private List<DubsInfo> dubs;

    @SerializedName("duration")
    private String duration;

    @SerializedName(alternate = {"durationSeconds"}, value = "seconds")
    private Integer durationSeconds;
    private List<ExplainBean> explains;

    @SerializedName("genre")
    private String genre;

    @SerializedName("hasResource")
    private Boolean hasResource;

    @SerializedName("imdbRatingValue")
    private String imdbRate;
    private boolean isCache;

    @SerializedName("isPaid")
    private int isPaid;

    @SerializedName(TmcConstants.KEY_LANGUAGE)
    private String language;

    @SerializedName("likeStatus")
    private Integer likeStatus;
    private transient long loadCoverDuration;
    private transient boolean loadCoverSuccess;

    @SerializedName("minitvType")
    private int miniTvType;

    @SerializedName("mySeeTime")
    private String mySeeTime;

    @SerializedName("needPaid")
    private int needPaid;
    private transient BiddingNativeManager nonAdDelegate;

    @SerializedName("ops")
    private String ops;
    private PlayUrl playUrl;

    @SerializedName("postTitle")
    private String postTitle;

    @SerializedName("releaseDate")
    private String releaseDate;

    @SerializedName("resourceDetectors")
    private List<ResourceDetectors> resourceDetectors;
    private String restrictLevel;
    private Integer seNum;
    private int season;

    @SerializedName("seenStatus")
    private Integer seenStatus;
    private transient boolean series;

    @SerializedName("favInfo")
    private ShortTVFavInfo shortTVFavInfo;

    @SerializedName("firstEp")
    private ShortTVItem shortTVFirstEp;
    private transient boolean showTitle;

    @SerializedName("skuInfo")
    private SkuInfo skuInfo;

    @SerializedName("staffList")
    private List<? extends Staff> staffList;

    @SerializedName("stills")
    private Cover stills;

    @SerializedName("subjectId")
    private String subjectId;

    @SerializedName("subjectType")
    private Integer subjectType;
    private String subtitles;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName(CampaignEx.JSON_KEY_TITLE)
    private String title;

    @SerializedName(alternate = {"shortsEpisode"}, value = "totalEpisode")
    private int totalEpisode;
    private long totalSize;

    @SerializedName("trailer")
    private Trailer trailer;

    @SerializedName("unlockFrom")
    private int unlockFrom;

    @SerializedName("unlockType")
    private List<Integer> unlockType;
    private List<Integer> unlockedEps;

    @SerializedName("viewers")
    private Long viewers;

    @SerializedName("wantToSeeCount")
    private Long wantToSeeCount;

    public Subject() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, false, null, null, 0, 0, null, 0, null, 0, null, -1, 1073741823, null);
    }

    public Subject(String str, Integer num, String str2, String str3, Cover cover, String str4, String str5, String str6, Integer num2, String str7, List<String> list, String str8, String str9, String str10, String str11, Integer num3, List<? extends Staff> list2, Long l11, Boolean bool, String str12, SubjectDl subjectDl, List<ResourceDetectors> list3, Cover cover2, Trailer trailer, boolean z10, boolean z11, BiddingNativeManager biddingNativeManager, String str13, Long l12, String str14, String str15, boolean z12, boolean z13, ShortTVItem shortTVItem, ShortTVFavInfo shortTVFavInfo, int i11, boolean z14, boolean z15, long j11, String str16, List<ExplainBean> list4, long j12, List<Integer> list5, int i12, boolean z16, Integer num4, int i13, String str17, List<DubsInfo> list6, String str18, String str19, Long l13, boolean z17, Integer num5, PlayUrl playUrl, int i14, int i15, List<Integer> unlockType, int i16, SkuInfo skuInfo, int i17, Set<Integer> adUnlockedEps) {
        Intrinsics.h(unlockType, "unlockType");
        Intrinsics.h(adUnlockedEps, "adUnlockedEps");
        this.subjectId = str;
        this.subjectType = num;
        this.title = str2;
        this.countryName = str3;
        this.cover = cover;
        this.releaseDate = str4;
        this.description = str5;
        this.duration = str6;
        this.durationSeconds = num2;
        this.genre = str7;
        this.tags = list;
        this.tag = str8;
        this.imdbRate = str9;
        this.language = str10;
        this.mySeeTime = str11;
        this.seenStatus = num3;
        this.staffList = list2;
        this.wantToSeeCount = l11;
        this.hasResource = bool;
        this.ops = str12;
        this.download = subjectDl;
        this.resourceDetectors = list3;
        this.stills = cover2;
        this.trailer = trailer;
        this.series = z10;
        this.correlation = z11;
        this.nonAdDelegate = biddingNativeManager;
        this.postTitle = str13;
        this.viewers = l12;
        this.contentRating = str14;
        this.category = str15;
        this.builtIn = z12;
        this.isCache = z13;
        this.shortTVFirstEp = shortTVItem;
        this.shortTVFavInfo = shortTVFavInfo;
        this.totalEpisode = i11;
        this.loadCoverSuccess = z14;
        this.coverCache = z15;
        this.loadCoverDuration = j11;
        this.aka = str16;
        this.explains = list4;
        this.totalSize = j12;
        this.unlockedEps = list5;
        this.coinPerEp = i12;
        this.deleted = z16;
        this.seNum = num4;
        this.season = i13;
        this.subtitles = str17;
        this.dubs = list6;
        this.corner = str18;
        this.restrictLevel = str19;
        this.appointmentCnt = l13;
        this.showTitle = z17;
        this.likeStatus = num5;
        this.playUrl = playUrl;
        this.miniTvType = i14;
        this.needPaid = i15;
        this.unlockType = unlockType;
        this.isPaid = i16;
        this.skuInfo = skuInfo;
        this.unlockFrom = i17;
        this.adUnlockedEps = adUnlockedEps;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Subject(java.lang.String r65, java.lang.Integer r66, java.lang.String r67, java.lang.String r68, com.transsion.shorttv.bean.Cover r69, java.lang.String r70, java.lang.String r71, java.lang.String r72, java.lang.Integer r73, java.lang.String r74, java.util.List r75, java.lang.String r76, java.lang.String r77, java.lang.String r78, java.lang.String r79, java.lang.Integer r80, java.util.List r81, java.lang.Long r82, java.lang.Boolean r83, java.lang.String r84, com.transsion.shorttv.bean.SubjectDl r85, java.util.List r86, com.transsion.shorttv.bean.Cover r87, com.transsion.shorttv.bean.Trailer r88, boolean r89, boolean r90, com.transsion.ad.bidding.nativead.BiddingNativeManager r91, java.lang.String r92, java.lang.Long r93, java.lang.String r94, java.lang.String r95, boolean r96, boolean r97, com.transsion.shorttv.bean.ShortTVItem r98, com.transsion.shorttv.bean.ShortTVFavInfo r99, int r100, boolean r101, boolean r102, long r103, java.lang.String r105, java.util.List r106, long r107, java.util.List r109, int r110, boolean r111, java.lang.Integer r112, int r113, java.lang.String r114, java.util.List r115, java.lang.String r116, java.lang.String r117, java.lang.Long r118, boolean r119, java.lang.Integer r120, com.transsion.shorttv.bean.PlayUrl r121, int r122, int r123, java.util.List r124, int r125, com.transsion.shorttv.bean.SkuInfo r126, int r127, java.util.Set r128, int r129, int r130, kotlin.jvm.internal.DefaultConstructorMarker r131) {
        /*
            Method dump skipped, instructions count: 771
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.bean.Subject.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, com.transsion.shorttv.bean.Cover, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.util.List, java.lang.Long, java.lang.Boolean, java.lang.String, com.transsion.shorttv.bean.SubjectDl, java.util.List, com.transsion.shorttv.bean.Cover, com.transsion.shorttv.bean.Trailer, boolean, boolean, com.transsion.ad.bidding.nativead.BiddingNativeManager, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, boolean, boolean, com.transsion.shorttv.bean.ShortTVItem, com.transsion.shorttv.bean.ShortTVFavInfo, int, boolean, boolean, long, java.lang.String, java.util.List, long, java.util.List, int, boolean, java.lang.Integer, int, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.Long, boolean, java.lang.Integer, com.transsion.shorttv.bean.PlayUrl, int, int, java.util.List, int, com.transsion.shorttv.bean.SkuInfo, int, java.util.Set, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Deprecated
    public static /* synthetic */ void getDownload$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getResourceDetectors$annotations() {
    }

    public final native Subject copyData();

    public final native Set getAdUnlockedEps();

    public final native String getAka();

    public final native Long getAppointmentCnt();

    public final native boolean getBuiltIn();

    public final native String getCategory();

    public final native int getCoinPerEp();

    public final native String getContentRating();

    public final native String getCorner();

    public final native boolean getCorrelation();

    public final native String getCountryName();

    public final native Cover getCover();

    public final native boolean getCoverCache();

    public final native boolean getDeleted();

    public final native String getDescription();

    public final native SubjectDl getDownload();

    public final native List getDubs();

    public final native String getDuration();

    public final native Integer getDurationSeconds();

    public final native List getExplains();

    public final native String getGenre();

    public final native Boolean getHasResource();

    public final native String getImdbRate();

    public final native String getLanguage();

    public final native Integer getLikeStatus();

    public final native long getLoadCoverDuration();

    public final native boolean getLoadCoverSuccess();

    public final native int getMiniTvType();

    public final native String getMySeeTime();

    public final native int getNeedPaid();

    public final native BiddingNativeManager getNonAdDelegate();

    public final native String getOps();

    public final native PlayUrl getPlayUrl();

    public final native String getPostTitle();

    public final native String getReleaseDate();

    public final native long getResourceAboutDuration();

    public final native ResourceDetectors getResourceDetector();

    public final native List getResourceDetectors();

    public final native String getRestrictLevel();

    public final native Integer getSeNum();

    public final native int getSeason();

    public final native Integer getSeenStatus();

    public final native boolean getSeries();

    public final native ShortTVFavInfo getShortTVFavInfo();

    public final native ShortTVItem getShortTVFirstEp();

    public final native boolean getShowTitle();

    public final native SkuInfo getSkuInfo();

    public final native List getStaffList();

    public final native Cover getStills();

    public final native String getSubjectId();

    public final native Integer getSubjectType();

    public final native String getSubtitles();

    public final native String getTag();

    public final native List getTags();

    public final native String getTitle();

    public final native int getTotalEpisode();

    public final native long getTotalSize();

    public final native Trailer getTrailer();

    public final native int getUnlockFrom();

    public final native List getUnlockType();

    public final native List getUnlockedEps();

    public final native Long getViewers();

    public final native Long getWantToSeeCount();

    public final native boolean isCache();

    public final native int isPaid();

    public final native boolean isSeries();

    public final native boolean isShortTV();

    public final native void setAdUnlockedEps(Set set);

    public final native void setAka(String str);

    public final native void setAppointmentCnt(Long l11);

    public final native void setBuiltIn(boolean z10);

    public final native void setCache(boolean z10);

    public final native void setCategory(String str);

    public final native void setCoinPerEp(int i11);

    public final native void setContentRating(String str);

    public final native void setCorner(String str);

    public final native void setCorrelation(boolean z10);

    public final native void setCountryName(String str);

    public final native void setCover(Cover cover);

    public final native void setCoverCache(boolean z10);

    public final native void setDeleted(boolean z10);

    public final native void setDescription(String str);

    public final native void setDownload(SubjectDl subjectDl);

    public final native void setDubs(List list);

    public final native void setDuration(String str);

    public final native void setDurationSeconds(Integer num);

    public final native void setExplains(List list);

    public final native void setGenre(String str);

    public final native void setHasResource(Boolean bool);

    public final native void setImdbRate(String str);

    public final native void setLanguage(String str);

    public final native void setLikeStatus(Integer num);

    public final native void setLoadCoverDuration(long j11);

    public final native void setLoadCoverSuccess(boolean z10);

    public final native void setMiniTvType(int i11);

    public final native void setMySeeTime(String str);

    public final native void setNeedPaid(int i11);

    public final native void setNonAdDelegate(BiddingNativeManager biddingNativeManager);

    public final native void setOps(String str);

    public final native void setPaid(int i11);

    public final native void setPlayUrl(PlayUrl playUrl);

    public final native void setPostTitle(String str);

    public final native void setReleaseDate(String str);

    public final native void setResourceDetectors(List list);

    public final native void setRestrictLevel(String str);

    public final native void setSeNum(Integer num);

    public final native void setSeason(int i11);

    public final native void setSeenStatus(Integer num);

    public final native void setSeries(boolean z10);

    public final native void setShortTVFavInfo(ShortTVFavInfo shortTVFavInfo);

    public final native void setShortTVFirstEp(ShortTVItem shortTVItem);

    public final native void setShowTitle(boolean z10);

    public final native void setSkuInfo(SkuInfo skuInfo);

    public final native void setStaffList(List list);

    public final native void setStills(Cover cover);

    public final native void setSubjectId(String str);

    public final native void setSubjectType(Integer num);

    public final native void setSubtitles(String str);

    public final native void setTag(String str);

    public final native void setTags(List list);

    public final native void setTitle(String str);

    public final native void setTotalEpisode(int i11);

    public final native void setTotalSize(long j11);

    public final native void setTrailer(Trailer trailer);

    public final native void setUnlockFrom(int i11);

    public final native void setUnlockType(List list);

    public final native void setUnlockedEps(List list);

    public final native void setViewers(Long l11);

    public final native void setWantToSeeCount(Long l11);

    public final native String toStringAboutLock();
}
