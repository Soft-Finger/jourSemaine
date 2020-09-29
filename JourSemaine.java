/**
*Auteur : Moukaila YAhaya
*Titre : Déterminer le jour de la semaine (dimanche à lundi),
*	à partir d'une date fournie par l'utilisateur, date qui devra
*	être comprise entre le 1er janvier 1600 et le 31 décembre 2100
*Date : 26-09-2020
*Session : Automne 2020
*/

public class JourSemaine {
	
	public static void main(String[] args) {
		
			//Declarations des variables 
			int codeJanvier = 1;
			int codeFevrier = 2;
			int codeMars = 3;
			int codeAvril = 4;
			int codeMai = 5;
			int codeJuin = 6;
			int codeJuillet = 7;
			int codeAout = 8;
			int codeSeptembre = 9;
			int codeOctobre = 10;
			int codeNovembre = 11;
			int codeDecembre = 12;
			
			int annee;
			int jour;
			int mois;
			String jourSemaine = "";
			int jourEntree;
			int moisEntree;
			int anneeEntre;
			int deux_premier_chiffres;
			//int mois_a_recuperer;
			//int jour_a_recuperer;
			//int annee_a_recuprer;
			//int anneeBissexile;
			int terme_1;
			int terme_2;
			int terme_3;        
			int terme_4;
			int terme_5;
			int terme_6;
			int sommeCinqueTermes = 0;
			int resteDivision_7 = 0;
			int dernier_jour_mois;
			
			int codeLundi = 0;
			int codeMardi = 1;
			int codeMercredi = 2;
			int codeJeudi = 3;
			int codeVendredi = 4;
			int codeSamedi = 5;
			int codeDimanche = 6;
			
			/* String lundi;
			String mardi;
			String mercredi;
			String jeudi;
			String vendredi;
			String samedi;
			String dimanche; */
			//String nom_jour_en_lettre;
			String jourEnLettre = " ";
			String moisEnLettre = " ";
			String dateEnchaine;
			
			boolean jour_valide;
			boolean mois_valide;
			boolean annee_valide;
			boolean annee_bissexile;
		
		System.out.print("Entrer l'année : ");
		annee = Keyboard.readInt();
		
		//Validation année
		
		if(annee < 1600) {
			System.out.println("Année trop petite entre (1600 et 2199)");
			System.exit(0);
		}else {
			if(annee > 2199) {
			System.out.println("Année trop grande entre (1600 et 2199)");
			System.exit(0);
			}else {
				annee_valide = true;
			}
		}
		
		//Validation si l'année est bissexile ou non.
	
		if(annee % 400 == 0) {
			annee_bissexile =true;
				}else {
					if(annee % 4 == 0 && annee % 100 != 0) {
						annee_bissexile = true;
						}else {
							annee_bissexile = false;
			}
		}
		
		System.out.print("Entrer le mois : ");
		mois = Keyboard.readInt();
		
		//Validation du mois 
		
		if(mois < 1) {
			System.out.println("Mois trop petit, entre (1 et 12 seulement)");
			System.exit(0);
		}else {
			if(mois > 12) {
			System.out.println("Mois trop grand, entre (1 et 12 seulement)");
			System.exit(0);
			}else {
				mois_valide = true;
			}
		}
				
		//Nombre maximum de jours dans le mois
		
		if(mois == codeJanvier || mois == codeMars || mois == codeMai || mois == codeJuillet || mois == codeAout || mois == codeOctobre || mois == codeDecembre) {
			dernier_jour_mois = 31;
		} else  
			if(mois == codeAvril || mois == codeJuin || mois == codeSeptembre || mois == codeNovembre){
				dernier_jour_mois = 30;
			}else 
				if((mois == codeFevrier) && (annee_bissexile = true)) {
					dernier_jour_mois = 29;
				}else {
					dernier_jour_mois = 28;
				}
				
		//Validation du jour 
		
		System.out.print("Entrer le jour : ");
		jour = Keyboard.readInt();
		
		if(mois == codeJanvier || mois == codeMars || mois == codeMai || mois == codeJuillet || mois == codeAout || mois == codeOctobre || mois == codeDecembre) {
			if(jour >= 1 && jour <= 31) {
				jour_valide = true;
			}else {
				if(mois == codeAvril || mois == codeJuin || mois == codeSeptembre || mois == codeNovembre) {
					if(jour >= 1 && jour <= 30) {
						jour_valide = true;
					}else {
						if((mois == codeFevrier) && (annee_bissexile = true)) {
							if(jour >= 1 && jour <= 29) {
								jour_valide = true;
							}else {
								jour_valide = false;
							}
						}
					}
				}
			}
		}
		
		//Validation jour compris entre 1 et 31 et message d'erreur
		
		if(jour < 1) {
			System.out.println("Jour trop petit (1 à 31 seulement)");
			System.exit(0);
		}else {
			if(jour > 31) {
				System.out.println("Jour trop grand (1 à 31 seulement)");
				System.exit(0);
			}else {
				jour_valide = true;
			}
		}

		//Calcule du terme 1
		
		terme_1 = annee % 100;		
		
		//Calcule du terme 2
		
		terme_2 = terme_1 / 4;
		
		//Calcule du terme 3
				
		terme_3 = jour;		
		
		//Calcule du terme 4
		
		if(mois == codeJanvier || mois == codeMars || mois == codeNovembre) {
			terme_4 = 3;
		}else {
			if(mois == codeAvril || mois == codeJuillet) {
				terme_4 = 6;
			}else {
				if(mois == codeMai) {
					terme_4 = 1;
				}else {
					if(mois == codeJuin) {
						terme_4 = 4;
					} else {
						if(mois == codeAout) {
							terme_4 = 2;
						}else {
							if((mois == codeSeptembre) || (mois == codeDecembre)) {
								terme_4 = 5;
							}else {
								terme_4 = 0;
							}
						}
					}
				}
			}
		}	
		//System.out.println(terme_4);
		
		//Calcule du terme 5
		
		deux_premier_chiffres = (annee - terme_1) / 100;
		
		if(deux_premier_chiffres == 16 || deux_premier_chiffres == 20) {
			terme_5 = 6;
			}else {
				if(deux_premier_chiffres == 17 || deux_premier_chiffres == 21) {
					terme_5 = 4;
					}else {
						if(deux_premier_chiffres == 18) {
						terme_5 = 2;
						}else {
							terme_5 = 0;
				}
			}
		}
		
		//Calcule du terme 6
		
		if(annee_bissexile = true && (mois == codeJanvier || mois == codeFevrier)) {
			terme_6 = 1;
			}else {
				terme_6 = 0;
		}
		
		//calcule reste division par 7
		
		resteDivision_7 = ((terme_1 + terme_2 + terme_3 + terme_4 + terme_5) - terme_6) % 7;
		//System.out.println(resteDivision_7);
		
	// Conversion du numero du jour du numerique à l'alphabétique
		
		if(resteDivision_7 == 0) {
			jourEnLettre = "dimanche";
		}else {
			if(resteDivision_7 == 1) {
				jourEnLettre = "lundi";
			}else {
				if(resteDivision_7 == 2) {
					jourEnLettre = "mardi";
				}else {
					if(resteDivision_7 == 3) {
						jourEnLettre = "merceredi";
					}else {
						if(resteDivision_7 == 4) {
							jourEnLettre = "jeudi";
						}else {
							if(resteDivision_7 == 5) {
								jourEnLettre = "vendredi";
							}else {
								jourEnLettre = "samedi";
							}
						}
					}
				}
			}
		}
		
	// Conversion du numero du mois du numerique à l'alphabétique
	
	if(mois == codeJanvier) {
		moisEnLettre = "janvier";
	}else {
		if(mois == codeFevrier) {
			moisEnLettre = "fevrire";
		}else {
			if(mois == codeMars) {
				moisEnLettre = "mars";
			}else {
				if(mois == codeAvril) {
					moisEnLettre = "avril";
				}else {
					if(mois == codeMai) {
						moisEnLettre = "mai";
					}else {
						if(mois == codeJuin) {
							moisEnLettre = "juin";
						}else {
							if(mois == codeJuillet) {
								moisEnLettre = "juillet";
							}else {
								if(mois == codeAout) {
									moisEnLettre = "aout";
								}else {
									if(mois == codeSeptembre) {
										moisEnLettre = "septembre";
									}else {
										if(mois == codeOctobre) {
											moisEnLettre = "octobre";
										}else {
											if(mois == codeNovembre) {
												moisEnLettre = "novenmbre";
											}else {
												moisEnLettre = "decembre";
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}


		System.out.println("Le " + jour + " " + moisEnLettre + " " + annee + " est un " + jourEnLettre );
	
		
	}
}
	
