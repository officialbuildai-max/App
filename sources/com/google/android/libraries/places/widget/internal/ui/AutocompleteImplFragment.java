package com.google.android.libraries.places.widget.internal.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.core.content.b;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.c0;
import androidx.view.v0;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzdv;
import com.google.android.libraries.places.internal.zzkd;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzkv;
import com.google.android.libraries.places.internal.zzkw;
import com.google.android.libraries.places.internal.zzkx;
import com.google.android.libraries.places.internal.zzlh;
import com.google.android.libraries.places.internal.zzll;
import com.google.android.libraries.places.internal.zzln;
import com.google.android.libraries.places.internal.zzlq;
import com.google.android.libraries.places.internal.zzlr;
import com.google.android.libraries.places.internal.zzmt;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

@SuppressLint({"ValidFragment"})
/* loaded from: classes4.dex */
public final class AutocompleteImplFragment extends Fragment {
    private final PlacesClient zza;
    private final zzkt zzb;
    private final zzlr zzc;
    private final zzdv zzd;
    private zzln zze;
    private PlaceSelectionListener zzf;
    private EditText zzg;
    private RecyclerView zzh;
    private View zzi;
    private View zzj;
    private View zzk;
    private View zzl;
    private View zzm;
    private View zzn;
    private View zzo;
    private View zzp;
    private TextView zzq;
    private TextView zzr;
    private zzr zzs;
    private final zzj zzt;

    /* JADX INFO: Access modifiers changed from: private */
    public AutocompleteImplFragment(int i11, PlacesClient placesClient, zzkt zzktVar, zzlr zzlrVar, zzdv zzdvVar) {
        super(i11);
        this.zzt = new zzj(this, null);
        this.zza = placesClient;
        this.zzb = zzktVar;
        this.zzc = zzlrVar;
        this.zzd = zzdvVar;
    }

    public /* synthetic */ AutocompleteImplFragment(int i11, PlacesClient placesClient, zzkt zzktVar, zzlr zzlrVar, zzdv zzdvVar, zzm zzmVar) {
        this(i11, placesClient, zzktVar, zzlrVar, zzdvVar);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzlq zzlqVar = new zzlq(this.zzb.zzf(), this.zzb.zzh(), this.zzb.zzm(), this.zzd);
            zzln zzlnVar = (zzln) new v0(this, new zzll(new zzlh(this.zza, this.zzb, zzlqVar.zzh()), zzlqVar, this.zzc)).a(zzln.class);
            this.zze = zzlnVar;
            zzlnVar.zze(bundle);
            requireActivity().getOnBackPressedDispatcher().i(this, new zzf(this, true));
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.zze.zzi();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.zze.zzh();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(@RecentlyNonNull View view, @Nullable Bundle bundle) {
        int identifier;
        try {
            this.zzg = (EditText) view.findViewById(R.id.places_autocomplete_search_bar);
            this.zzh = (RecyclerView) view.findViewById(R.id.places_autocomplete_list);
            this.zzi = view.findViewById(R.id.places_autocomplete_back_button);
            this.zzj = view.findViewById(R.id.places_autocomplete_clear_button);
            this.zzk = view.findViewById(R.id.places_autocomplete_search_bar_separator);
            this.zzl = view.findViewById(R.id.places_autocomplete_progress);
            this.zzm = view.findViewById(R.id.places_autocomplete_try_again_progress);
            this.zzn = view.findViewById(R.id.places_autocomplete_powered_by_google);
            this.zzo = view.findViewById(R.id.places_autocomplete_powered_by_google_separator);
            this.zzp = view.findViewById(R.id.places_autocomplete_sad_cloud);
            this.zzq = (TextView) view.findViewById(R.id.places_autocomplete_error_message);
            this.zzr = (TextView) view.findViewById(R.id.places_autocomplete_try_again);
            this.zzg.addTextChangedListener(this.zzt);
            this.zzg.setOnFocusChangeListener(new zzl(null));
            this.zzg.setHint(TextUtils.isEmpty(this.zzb.zzl()) ? zzkw.zzc(requireContext(), R.string.places_autocomplete_search_hint) : this.zzb.zzl());
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            int ordinal = this.zzb.zzh().ordinal();
            if (ordinal == 0) {
                int zza = this.zzb.zza();
                int zzb = this.zzb.zzb();
                if (Color.alpha(zza) < 255) {
                    zza = 0;
                }
                if (zza != 0 && zzb != 0) {
                    int zza2 = zzkx.zza(zza, b.getColor(requireContext(), R.color.places_text_white_alpha_87), b.getColor(requireContext(), R.color.places_text_black_alpha_87));
                    int zza3 = zzkx.zza(zza, b.getColor(requireContext(), R.color.places_text_white_alpha_26), b.getColor(requireContext(), R.color.places_text_black_alpha_26));
                    view.findViewById(R.id.places_autocomplete_search_bar_container).setBackgroundColor(zza);
                    Window window = requireActivity().getWindow();
                    if (zzkx.zzc(zzb, -1, ViewCompat.MEASURED_STATE_MASK)) {
                        window.setStatusBarColor(zzb);
                        window.getDecorView().setSystemUiVisibility(8192);
                    } else {
                        window.setStatusBarColor(zzb);
                    }
                    this.zzg.setTextColor(zza2);
                    this.zzg.setHintTextColor(zza3);
                    zzkx.zzb((ImageView) this.zzi, zza2);
                    zzkx.zzb((ImageView) this.zzj, zza2);
                }
            } else if (ordinal == 1 && (identifier = getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                requireActivity().getWindow().addFlags(67108864);
                ViewCompat.setPaddingRelative(view, view.getPaddingLeft(), view.getPaddingTop() + getResources().getDimensionPixelSize(identifier), view.getPaddingRight(), view.getPaddingBottom());
            }
            this.zzi.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.ui.zzc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AutocompleteImplFragment.this.zzc(view2);
                }
            });
            this.zzj.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.ui.zzb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AutocompleteImplFragment.this.zzd(view2);
                }
            });
            this.zzr.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.ui.zze
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AutocompleteImplFragment.this.zzf(view2);
                }
            });
            this.zzs = new zzr(new zzd(this));
            this.zzh.setLayoutManager(new LinearLayoutManager(requireContext()));
            this.zzh.setItemAnimator(new zzo(getResources()));
            this.zzh.setAdapter(this.zzs);
            this.zzh.addOnScrollListener(new zzg(this));
            this.zze.zza().j(getViewLifecycleOwner(), new c0() { // from class: com.google.android.libraries.places.widget.internal.ui.zza
                @Override // androidx.view.c0
                public final void onChanged(Object obj) {
                    AutocompleteImplFragment.this.zzg((zzkv) obj);
                }
            });
        } catch (Error e11) {
            e = e11;
            zzkd.zzb(e);
            throw e;
        } catch (RuntimeException e12) {
            e = e12;
            zzkd.zzb(e);
            throw e;
        }
    }

    public final /* synthetic */ void zzc(View view) {
        this.zze.zzj();
    }

    public final /* synthetic */ void zzd(View view) {
        try {
            this.zze.zzk();
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public final /* synthetic */ void zze(AutocompletePrediction autocompletePrediction, int i11) {
        try {
            this.zze.zzf(autocompletePrediction, i11);
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public final /* synthetic */ void zzf(View view) {
        try {
            this.zze.zzl(this.zzg.getText().toString(), this.zzg.getSelectionEnd());
        } catch (Error | RuntimeException e11) {
            zzkd.zzb(e11);
            throw e11;
        }
    }

    public final /* synthetic */ void zzg(zzkv zzkvVar) {
        try {
            this.zzj.setVisibility(0);
            this.zzk.setVisibility(0);
            this.zzl.setVisibility(8);
            this.zzm.setVisibility(8);
            this.zzn.setVisibility(0);
            this.zzo.setVisibility(8);
            this.zzp.setVisibility(8);
            this.zzq.setVisibility(8);
            this.zzr.setVisibility(8);
            AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
            switch (zzkvVar.zzf() - 1) {
                case 0:
                    if (TextUtils.isEmpty(this.zzb.zzm())) {
                        this.zzj.setVisibility(8);
                    }
                    this.zzg.requestFocus();
                    this.zzg.setText(this.zzb.zzm());
                    EditText editText = this.zzg;
                    editText.setSelection(editText.getText().length());
                    return;
                case 1:
                    this.zzs.submitList(null);
                    this.zzj.setVisibility(8);
                    this.zzg.getText().clear();
                    return;
                case 2:
                    this.zzl.setVisibility(0);
                    return;
                case 3:
                    this.zzr.setVisibility(8);
                    this.zzm.setVisibility(0);
                    this.zzn.setVisibility(8);
                    this.zzp.setVisibility(0);
                    this.zzq.setVisibility(0);
                    return;
                case 4:
                    this.zzs.submitList(zzkvVar.zzd());
                    this.zzo.setVisibility(0);
                    return;
                case 5:
                    this.zzs.submitList(null);
                    this.zzn.setVisibility(8);
                    this.zzp.setVisibility(0);
                    this.zzr.setVisibility(4);
                    this.zzq.setText(getString(R.string.places_autocomplete_no_results_for_query, zzkvVar.zze()));
                    this.zzq.setVisibility(0);
                    return;
                case 6:
                    break;
                case 7:
                default:
                    PlaceSelectionListener placeSelectionListener = this.zzf;
                    Place zzc = zzkvVar.zzc();
                    if (zzc == null) {
                        throw null;
                    }
                    placeSelectionListener.onPlaceSelected(zzc);
                    return;
                case 8:
                    AutocompletePrediction zzb = zzkvVar.zzb();
                    zzmt.zzc(zzb, "Prediction should not be null.");
                    this.zzg.clearFocus();
                    this.zzg.removeTextChangedListener(this.zzt);
                    this.zzg.setText(zzb.getPrimaryText(null));
                    this.zzg.addTextChangedListener(this.zzt);
                    break;
                case 9:
                    PlaceSelectionListener placeSelectionListener2 = this.zzf;
                    Status zza = zzkvVar.zza();
                    if (zza == null) {
                        throw null;
                    }
                    placeSelectionListener2.onError(zza);
                    return;
            }
            this.zzs.submitList(null);
            this.zzn.setVisibility(8);
            this.zzp.setVisibility(0);
            this.zzr.setVisibility(0);
            this.zzq.setText(getString(R.string.places_search_error));
            this.zzq.setVisibility(0);
        } catch (Error e11) {
            e = e11;
            zzkd.zzb(e);
            throw e;
        } catch (RuntimeException e12) {
            e = e12;
            zzkd.zzb(e);
            throw e;
        }
    }

    public final void zzh(@RecentlyNonNull PlaceSelectionListener placeSelectionListener) {
        this.zzf = placeSelectionListener;
    }
}
