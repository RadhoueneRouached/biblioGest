package isamm.tn.services;

import isamm.tn.beans.Administrateur;
import isamm.tn.dao.AdministrateurDAO;

 interface AdministrateurService {


		public void setAdministrateurDAO(AdministrateurDAO administrateurDAO);

		public void createAdministrateur(Administrateur administrateur);

		public Administrateur findAdministrateur(int id);

	}
