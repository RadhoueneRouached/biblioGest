package isamm.tn.dao;

import isamm.tn.beans.Adherent;
import isamm.tn.beans.Administrateur;
import isamm.tn.beans.Adresse;
import isamm.tn.beans.Document;
import isamm.tn.beans.Emprunt;
import isamm.tn.beans.Support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

public class Test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws ParseException {
		AbstarctDAOFactory adf = AbstarctDAOFactory.getFactory(0);

		DAO<Adherent> adherentDao = adf.getAdherentDAO();
		DAO<Document> documentDao = adf.getDocumentDAO();
		DAO<Administrateur> adminDao = adf.getAdministrateurDAO();
		DAO<Emprunt> empruntDao = adf.getEmpruntDAO();

		@SuppressWarnings("unchecked")
		DAO<Adresse> adresseDao = adf.getAdresseDAO();

		String date1 = "22/06/2006";
		int choixMenu, choixMenuAdherent;

		// simpleDateFormat.format(date1);

		String choixSousMenu = "c";
		String choixSousMenu2 = "c";
		String choixSousMenu3 = "c";
		String choixMenuGen = "c";

		java.util.Scanner entree = new java.util.Scanner(System.in);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		while (choixMenuGen.equals("c")) {
			System.out.println("*******************************************");
			System.out.println("*******************************************");
			System.out.println("**** 1- Gerer Aherents");
			System.out.println("**** 2- Gerer Documents");
			System.out.println("**** 3- Gerer Emprunts");
			System.out.println("*******************************************");
			choixMenu = entree.nextInt();
			entree.nextLine();

			switch (choixMenu) {
			case 1:

				while (choixSousMenu.equals("c")) {

					System.out
							.println("*******************************************");
					System.out.println("**** 1- Ajouter Aherent   ");
					System.out.println("**** 2- Modifier Aherent  ");
					System.out.println("**** 3- Supprimer Aherent ");
					System.out.println("**** 4- Consulter tous les Aherents ");
					System.out.println("**** 5- Nombre total des adherent");
					System.out.println("**** 6- Nombre total des adherent");
					System.out.println("*******************************************");
					choixMenuAdherent = entree.nextInt();

					switch (choixMenuAdherent) {
					case 1:

						Adresse adresse = new Adresse();
						Adherent adherent = new Adherent();
//						Administrateur administrateur = new Administrateur();
//						administrateur.setLogin("admin");
//						administrateur.setMotDePass("admin");
//						adminDao.create(administrateur);
						Administrateur administrateur2 = new Administrateur();
						administrateur2 = adminDao.find(1);

						System.out.print(" Donner votre nom ");
						adherent.setNom(entree.next());
						System.out.print(" Donner votre prenom ");
						adherent.setPrenom(entree.next());
						entree.nextLine();
						System.out.print(" Donner votre cin ");
						adherent.setCin(entree.nextInt());
						entree.nextLine();
						adherent.setActive(0); 
						System.out.print(" Donner votre email ");
						adherent.setEmail(entree.next());
						System.out.print(" Donner votre date 1de naissance ");
						adherent.setDateNaissance(entree.next());
						entree.nextLine();
						

						System.out.print(" Donner votre N°rue ");
						adresse.setNumRue(entree.nextInt());
						entree.nextLine();
						System.out.print(" Donner votre rue ");
						adresse.setRue(entree.next());
						System.out.print(" Donner votre cite ");
						adresse.setCite(entree.next());
						System.out.print(" Donner votre Ville ");
						adresse.setVille(entree.next());
						adherent.setAdministrateur(administrateur2);
						adresse.setAdherent(adherent);
						adresseDao.create(adresse);
						adherent.setAdresse(adresse);

						try {

							adherentDao.create(adherent);
						} catch (Exception e) {
							System.out.print("Adherent ne pe pas etre cree ");
							e.printStackTrace();
						}
						System.out.print(" Adherent ajoué avec succés ");

						break;
					case 2:
						int idAdherentModifier = 0;
						Adherent adherent3 = new Adherent();
						System.out
								.print(" Entrer l'id de l'adherent a modifier ");
						idAdherentModifier = entree.nextInt();
						adherent3 = adherentDao.find(idAdherentModifier);
						System.out.println(" Nom adherent  a modifier : "
								+ adherent3.getNom());
						Adresse adresse2 = new Adresse();
						String modifAdherent = "c";
						while (modifAdherent.equals("c")) {

							System.out.print(" Donner votre nom ");
							adherent3.setNom(entree.next());
							System.out.print(" Donner votre prenom ");
							adherent3.setPrenom(entree.next());
							entree.nextLine();
							System.out.print(" Donner votre cin ");
							adherent3.setCin(entree.nextInt());
							entree.nextLine();
							System.out.print(" Donner valeur adherent active 0 sinon 1 ");
							adherent3.setActive(entree.nextInt());
							entree.nextLine();
							System.out.print(" Donner votre email ");
							adherent3.setEmail(entree.next());
							System.out
									.print(" Donner votre date 1de naissance ");
							adherent3.setDateNaissance(entree.next());
							entree.nextLine();

							System.out.print(" Donner votre N°rue ");
							adherent3.getAdresse().setNumRue(entree.nextInt());
							entree.nextLine();
							System.out.print(" Donner votre rue ");
							adherent3.getAdresse().setRue(entree.next());
							System.out.print(" Donner votre cite ");
							adherent3.getAdresse().setCite(entree.next());
							System.out.print(" Donner votre Ville ");
							adresse2.setVille(entree.next());

							System.out.println("etes vous sur de modifier ?");
							System.out.println("appuyez sur c sinon ");
							modifAdherent = entree.next();
						}

						if (adherentDao.update(adherent3))
							System.out
									.println(" adherent modifié avec succes ! ");
						else
							System.out
									.println(" adherent n'est pas modifié ! ");

						break;

					case 3:
						int idAdherentDelete = 0;
						Adherent adherent2 = new Adherent();
						System.out
								.print(" Entrer l'id de l'adherent a supprimer ");
						idAdherentDelete = entree.nextInt();
						adherent2 = adherentDao.find(idAdherentDelete);
						System.out.println(" Nom adherent  a supprimer : "
								+ adherent2.getNom());
						if (adherentDao.delete(adherent2))
							System.out
									.println(" adherent supprimé avec succes ! ");
						else
							System.out
									.println(" adherent n'est pas supprimé ! ");

						break;
					case 4:
						List l = new ArrayList<Adherent>();
						l = adherentDao.findAll();
						Iterator i = l.iterator();

						while (i.hasNext()) {
							Adherent ad = (Adherent) i.next();
							System.out.println("ID :" + ad.getId_adherent()
									+ " Nom :" + ad.getNom() + " Prenom : "
									+ ad.getPrenom() + " Cin:" + ad.getCin()+" "+ad.getAdresse().getCite());
						}
						break;
					case 5:
						Long lg ; 
						lg = ((AdherentDAO) adherentDao).nombreTotalAdherent(); 
						System.out.println("Nombre totale d\'adherent :" +lg);
						break;
					case 6:
						Administrateur a = null; 
						a = ((AdministrateurDAO) adminDao).findByLogin("admin", "admin"); 
						System.out.println("Admin :" +a.getId_admin());
						break;
						
					default:
						System.out.print(" re-executer le programme ");
						break;
					}

					System.out
							.println("voulez vous sortir ?? appuyez sur une touche");
					System.out.println("Pour continuer appuyez c");
					choixSousMenu = entree.next();

				}

				break;
			/**********************************************************************************************************/
			case 2:

				while (choixSousMenu2.equals("c")) {

					System.out
							.println("*******************************************");
					System.out.println("**** 1- Ajouter Document   ");
					System.out.println("**** 2- Modifier Document  ");
					System.out.println("**** 3- Supprimer Document ");
					System.out.println("**** 4- Consulter tous les Documents ");
					System.out.println("**** 5- Nombre totale Document ");
					System.out.println("**** 6- Recherche par Titre Document ");
					
					System.out
							.println("*******************************************");
					choixMenuAdherent = entree.nextInt();

					switch (choixMenuAdherent) {
					case 1:
						Document document = new Document();

						Administrateur administrateur = new Administrateur();
						administrateur.setLogin("admin");
						administrateur.setMotDePass("admin");
						adminDao.create(administrateur);
						Administrateur administrateur2 = new Administrateur();
						administrateur2 = adminDao.find(1);

						System.out.print(" Choisir type de support ");
						document.setType(entree.next());

						System.out.print(" Donner Titre ");
						document.setTitre(entree.next());
						// entree.nextLine();
						System.out.print(" Donner Description");
						document.setDescription(entree.next());
						System.out.print(" Donner nom d'auteur ");
						document.setAuteur(entree.next());

						System.out.print(" Donner numero d'edition  ");
						document.setNumEdition(entree.nextInt());
						entree.nextLine();

						System.out.print(" Donner date sortie ");
						document.setDateSorie(entree.next());
						System.out.print(" Donner nombre d'exemplaire ");
						document.setExemplaire(entree.nextInt());
						entree.nextLine();
						document.setAdministrateur(administrateur2);

						try {

							documentDao.create(document);
							System.out.print(" Document ajoué avec succés ");
						} catch (Exception e) {
							System.out.print("document ne pe pas etre cree ");
							e.printStackTrace();
						}

						break;
					case 2:
						int idDocModifier = 0;
						Document doc2 = new Document();

						System.out
								.print(" Entrer l'id du document a modifier ");
						idDocModifier = entree.nextInt();
						doc2 = documentDao.find(idDocModifier);
						System.out.println(" Titre du doc  a modifier : "
								+ doc2.getTitre());

						String modifDoc = "c";
						while (modifDoc.equals("c")) {

							System.out.print(" Choisir type de support ");
							doc2.setType(entree.next());

							System.out.print(" Donner Titre ");
							doc2.setTitre(entree.next());
							// entree.nextLine();
							System.out.print(" Donner Description");
							doc2.setDescription(entree.next());
							System.out.print(" Donner nom d'auteur ");
							doc2.setAuteur(entree.next());

							System.out.print(" Donner numero d'edition  ");
							doc2.setNumEdition(entree.nextInt());
							entree.nextLine();

							System.out.print(" Donner date sortie ");
							doc2.setDateSorie(entree.next());
							System.out.print(" Donner nombre d'exemplaire ");
							doc2.setExemplaire(entree.nextInt());
							entree.nextLine();

							Administrateur adm = new Administrateur();
							adm.setLogin("admin");
							adm.setMotDePass("admin");
							adminDao.create(adm);
							Administrateur adm3 = new Administrateur();
							adm3 = adminDao.find(1);
							doc2.setAdministrateur(adm3);

							System.out.println("etes vous sur de modifier ?");
							System.out.println("appuyez sur c sinon ");
							modifDoc = entree.next();
						}

						if (documentDao.update(doc2))
							System.out
									.println(" document  modifié avec succes ! ");
						else
							System.out
									.println(" document n'est pas modifié ! ");

						break;

					case 3:
						int idDocDelete = 0;
						Document document3 = new Document();
						System.out
								.print(" Entrer l'id de l'document a supprimer ");
						idDocDelete = entree.nextInt();
						document3 = documentDao.find(idDocDelete);
						System.out.println(" Titre document  a supprimer : "
								+ document3.getTitre());
						if (documentDao.delete(document3))
							System.out
									.println(" document supprimé avec succes ! ");
						else
							System.out
									.println(" document n'est pas supprimé ! ");

						break;
					case 4:
						List l = new ArrayList<Support>();
						l = documentDao.findAll();
						Iterator i = l.iterator();

						while (i.hasNext()) {
							Document dc = (Document) i.next();
							System.out.println("ID :" + dc.getId_support()
									+ " Titre :" + dc.getTitre() + " Auteur : "
									+ dc.getAuteur());
						}
						break;
					case 5:
						Long lg ; 
						lg = ((DocumentDAO) documentDao).nombreLivre(); 
						System.out.println("Nombre totale de livre :" +lg);
						break;
					case 6:
						String rech="le";
						Document rech1= new Document(); 
						 rech1 = ((DocumentDAO) documentDao).findByName(rech); 
						System.out.println("Auteur :" +rech1.getAuteur());
						break;
						
					default:
						System.out.print(" re-executer le programme ");
						break;
					}

					System.out
							.println("voulez vous sortir ?? appuyez sur une touche");
					System.out.println("Pour continuer appuyez c");
					choixSousMenu2 = entree.next();

				}

				break;
			/*********************************************************************************************************/
			case 3:

				while (choixSousMenu3.equals("c")) {

					System.out
							.println("*******************************************");
					System.out.println("**** 1- Ajouter Emprunt   ");
					System.out.println("**** 2- Modifier Emprunt  ");
					System.out.println("**** 3- Supprimer Emprunt ");
					System.out.println("**** 4- Consulter tous les Emprunts ");
					System.out.println("**** 5- Les Emprunts depassé ");
					System.out.println("**** 6- Emprunts par Adherent ");
					System.out.println("**** 7- Nombre Emprunts par Mois ");
					System.out.println("**** 8- Emprunts depassé par Mois ");
					System.out.println("**** 9- Emprunts Non confirmé ");
					System.out.println("**** 0- Mise a jour des emprunts");
					System.out
							.println("*******************************************");
					choixMenuAdherent = entree.nextInt();

					switch (choixMenuAdherent) {
					case 1:
						Emprunt emprunt = new Emprunt();
						Adherent ad2 = new Adherent();
						Document dc2 = new Document();
						Date dateDeb;
						int idEmpAjoutDoc = 0;
						int idEmpAjoutAdr = 0;
						System.out.print(" entrer date debut emprunt  ");
						dateDeb = simpleDateFormat.parse(entree.next());
						emprunt.setDateDeb((java.util.Date) dateDeb);

						Date dateFin;
						System.out.print(" entrer date fin emprunt ");
						dateFin = simpleDateFormat.parse(entree.next());
						emprunt.setDateFin((java.util.Date) dateFin);
						emprunt.setConfirme(0); 
						// entree.nextLine();

						emprunt.setDepasse((byte) 0);
						System.out.print(" Donner id document a emprunter ");
						idEmpAjoutDoc = entree.nextInt();
						try {
						dc2 = documentDao.find(idEmpAjoutDoc);
						System.out.println("ID Document : "+dc2.getId_support()+" Titre Document "+dc2.getTitre()); 
						}catch (Exception e) {
							System.out.print("Document non trouvé"); 
						}
						
						emprunt.setDocument(dc2);
						
						emprunt.setDepasse((byte) 0);
						System.out.println(" Donner id adherent  ");
						idEmpAjoutAdr = entree.nextInt();
						try {
						ad2 = adherentDao.find(idEmpAjoutAdr);
						System.out.print("ID Adherent  : "+ad2.getId_adherent()+" Nom & Prenom Adherent "+ad2.getNom() +" "+ ad2.getPrenom()); 
						}
						catch (Exception e) {
							System.out.print(" Adherent non trouvé "); 
						}
						
						
						emprunt.setAdherent(ad2);

						try {

							empruntDao.create(emprunt);
							System.out.print(" emprunt  ajouté avec succés ");
						} catch (Exception e) {
							System.out.print("emprunt ne pe pas etre cree ");
							e.printStackTrace();
						}

						break;
					case 2:
						int idEmpModifier = 0;
						Emprunt emprunt2 = new Emprunt();
						Emprunt emprunt4 = new Emprunt();
						
						Adherent ad3 = new Adherent(); 
						Document dc3 = new Document(); 

						Date dateDeb1 = null; 
						Date dateFin1 = null;
						
						
						
						System.out
								.print(" Entrer l'id de emprunt a modifier ");
						idEmpModifier = entree.nextInt();
						emprunt2 = empruntDao.find(idEmpModifier);
						System.out.println(" ID d'emprunt  a modifier : "
								+ emprunt2.getId_emp());

						entree.nextLine();
						//String modifEmp = "c";
						System.out.print(" entrer emprunt depassé ou non ");
						System.out.print(" 0 ==> NON ; 1 ==> OUI ");
						Byte x= entree.nextByte() ; 
						emprunt2.setDepasse(x);
						
							entree.nextLine();
							System.out.print(" entrer date debut emprunt  ");
							dateDeb1 = simpleDateFormat.parse(entree.next());
							emprunt2.setDateDeb( dateDeb1);

							entree.nextLine();
							
							System.out.print(" entrer date fin emprunt ");
							dateFin1 = simpleDateFormat.parse(entree.next());
							emprunt2.setDateFin(dateFin1);
							 entree.nextLine();
							 
							 
							
							System.out.print(" Donner id document a emprunter ");
							idEmpAjoutDoc = entree.nextInt();
							try {
							dc3 = documentDao.find(idEmpAjoutDoc);
							System.out.println("ID Document : "+dc3.getId_support()+" Titre Document "+dc3.getTitre()); 
							}catch (Exception e) {
								System.out.print("Document non trouvé"); 
							}
							
							emprunt2.setDocument(dc3);

							emprunt2.setDepasse((byte) 0);
							System.out.println(" Donner id adherent  ");
							idEmpAjoutAdr = entree.nextInt();
							 entree.nextLine();
							System.out.print(" confirmer =+> 1 , sinon 0 ");
							emprunt2.setConfirme(entree.nextInt());
							 entree.nextLine();
							 
							try {
							ad3 = adherentDao.find(idEmpAjoutAdr);
							System.out.println("ID Adherent  : "+ad3.getId_adherent()+" Nom & Prenom Adherent "+ad3.getNom() +" "+ ad3.getPrenom()); 
							}
							catch (Exception e) {
								System.out.println(" Adherent non trouvé "); 
							}
							
							
							emprunt2.setAdherent(ad3);
						
							
						if (empruntDao.update(emprunt2))
							System.out
									.println(" emprunt  modifié avec succes ! ");
						else
							System.out
									.println(" emprunt n'est pas modifié ! ");

						break;

					case 3:
						int idEmpDelete = 0;
						Emprunt emprunt3 = new Emprunt();
						System.out
								.print(" Entrer l'id de l'emprunt a supprimer ");
						idEmpDelete = entree.nextInt();
						emprunt3 = empruntDao.find(idEmpDelete);
						System.out.println(" ID emprunt  a supprimer : "
								+ emprunt3.getId_emp());
						if (empruntDao.delete(emprunt3))
							System.out
									.println(" emprunt supprimé avec succes ! ");
						else
							System.out
									.println(" emprunt n'est pas supprimé ! ");

						break;
					case 4:
						List l = new ArrayList<Emprunt>();
						l = empruntDao.findAll();
						Iterator i = l.iterator();

						while (i.hasNext()) {
							Emprunt emp = (Emprunt) i.next();
							System.out.println("ID :" + emp.getId_emp()
									+ " date_deb :" + emp.getDateDeb() + " date_fin : "
									+ emp.getDateFin()+" Nom adherent "+emp.getAdherent().getNom() +" titre document emprunté "+emp.getDocument().getTitre());
						}
						break;
						
					case 5:
						List lEmp = new ArrayList<Emprunt>();
						lEmp =  ((EmpruntDAO) empruntDao).empruntDepasse(); 
						Iterator i1 = lEmp.iterator();

						while (i1.hasNext()) {
							Emprunt emp = (Emprunt) i1.next();
							System.out.println("***************** Emprunt Depassé"); 
							System.out.println("ID :" + emp.getId_emp()
									+ " date_deb :" + emp.getDateDeb() + " date_fin : "
									+ emp.getDateFin()+" Nom adherent "+emp.getAdherent().getNom() +" titre document emprunté "+emp.getDocument().getTitre()+" depasse "+emp.getDepasse());
						}
						break;
						
					case 6:
						List lEmpParAdherent = new ArrayList<Emprunt>();
						lEmpParAdherent =  ((EmpruntDAO) empruntDao).EmpruntParAdherent(); 
						Iterator i2 = lEmpParAdherent.iterator();

						while (i2.hasNext()) {
							Emprunt emp = (Emprunt) i2.next();
							System.out.println("***************** Emprunt Par Adherent"); 
							System.out.println("ID :" + emp.getId_emp()
									+ " date_deb :" + emp.getDateDeb() + " date_fin : "
									+ emp.getDateFin()+" Nom adherent "+emp.getAdherent().getNom() +" titre document emprunté "+emp.getDocument().getTitre()+" depasse "+emp.getDepasse());
						}
						break;
					case 7:
						Long lEmpParMois = null;
						lEmpParMois =  ((EmpruntDAO) empruntDao).nombreEmpruntParMois("1/12/2012", "31/12/2012"); 
													
							
							System.out.println("***************** Emprunt Par Mois"); 
							System.out.println("Nombre d'emprunt du mois sont  :"+ lEmpParMois);
						
						break;
					case 8:
						List lEmp1 = new ArrayList<Emprunt>();
						lEmp1 =  ((EmpruntDAO) empruntDao).empruntDepasseParMois("31/12/2012"); 
						try {
						Iterator i11 = lEmp1.iterator();
						
						while (i11.hasNext()) {
							Emprunt emp = (Emprunt) i11.next();
							System.out.println("***************** Emprunt Depassé par mois"); 
							System.out.println("ID :" + emp.getId_emp()
									+ " date_deb :" + emp.getDateDeb() + " date_fin : "
									+ emp.getDateFin()+" Nom adherent "+emp.getAdherent().getNom() +" titre document emprunté "+emp.getDocument().getTitre()+" depasse "+emp.getDepasse());
						}
						}catch (Exception e) {
							System.out.print("Pas de emprunt depasse pour ce mois "); 
						
						}
						
						break;
					case 9:
						List lEmp11 = new ArrayList<Emprunt>();
						lEmp11 =  ((EmpruntDAO) empruntDao).empruntNonConfirmer(); 
						try {
							
						
						Iterator i11 = lEmp11.iterator();

						while (i11.hasNext()) {
							Emprunt emp = (Emprunt) i11.next();
							System.out.println("***************** Emprunt Non Confirmé"); 
							System.out.println("ID :" + emp.getId_emp()
									+ " date_deb :" + emp.getDateDeb() + " date_fin : "
									+ emp.getDateFin()+" Nom adherent "+emp.getAdherent().getNom() +" titre document emprunté "+emp.getDocument().getTitre()+" depasse "+emp.getDepasse());
						}
						}catch (Exception e) {
							System.out.print("Pas de emprunt a confirmer pour ce mois "); 
						
						}
						
						
						break;
						
					case 0:
						String  maja = null;
						maja =  ((EmpruntDAO) empruntDao).miseAJourAdherentDepasse(); 
													
							
							System.out.println("***************** Emprunt mise a jour"); 
							System.out.println("Mise a jour :"+ maja);
						
						break;
						
					default:
						System.out.print(" re-executer le programme ");
						break;
					}

					System.out
							.println("voulez vous sortir ?? appuyez sur une touche");
					System.out.println("Pour continuer appuyez c");
					choixSousMenu3 = entree.next();

				}

				break;
			default:
				System.out.print(" re-executer le programme ");
				break;

			}
			
			System.out.println("Pour Revenir au Menu principale APPUYEZ sur c");
			choixMenuGen = entree.next();

		}

	}
}
