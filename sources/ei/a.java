package ei;

import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.bidding.interstitial.BiddingBuyOutBuyOutInterstitialHalfScreenActivity;
import com.transsion.ad.bidding.interstitial.BiddingBuyOutFullScreenInterstitialActivity;
import com.transsion.ad.bidding.interstitial.BiddingBuyOutInterstitialActionActivity;
import com.transsion.ad.bidding.interstitial.BiddingBuyOutInterstitialAutoFullScreenActivity;

/* loaded from: classes6.dex */
public final class a extends AbsBiddingBuyOutGemini {
    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public Class c() {
        String e11 = e();
        int hashCode = e11.hashCode();
        if (hashCode != -1008505828) {
            if (hashCode != -145498037) {
                if (hashCode == 1099969393 && e11.equals("action_dialog")) {
                    return BiddingBuyOutInterstitialActionActivity.class;
                }
            } else if (e11.equals("auto_fullscreen")) {
                return BiddingBuyOutInterstitialAutoFullScreenActivity.class;
            }
        } else if (e11.equals("full_screen")) {
            return BiddingBuyOutFullScreenInterstitialActivity.class;
        }
        return BiddingBuyOutBuyOutInterstitialHalfScreenActivity.class;
    }

    @Override // com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini
    public String f() {
        return com.vungle.ads.internal.b.PLACEMENT_TYPE_INTERSTITIAL;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_int";
    }
}
