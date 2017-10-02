package com.app.projet.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.app.projet.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.projet.entities.LigneDeCommande;
import com.app.projet.exceptions.StockNegatifException;

@Repository
@Transactional
public class LigneDeCommandeDaoImpl implements LigneDeCommandeDao {
	
	@Autowired
	LigneDeCommandeRepository lcRepo;

	@Override
	public LigneDeCommande create(LigneDeCommande t) {
		
		return lcRepo.saveAndFlush(t);
	}

	@Override
	public LigneDeCommande update(LigneDeCommande t) throws StockNegatifException {
		LigneDeCommande lc = lcRepo.findOne(t.getId());
		lc.setFicheCommande(t.getFicheCommande());
		lc.setQuantite(t.getQuantite());
		lc.setProduit(t.getProduit());
		return lcRepo.save(lc);
	}

	@Override
	public LigneDeCommande find(Long s) {
		// TODO Auto-generated method stub
		return lcRepo.findOne(s);
	}

	@Override
	public List<LigneDeCommande> findAll() {
		// TODO Auto-generated method stub
		return lcRepo.findAll();
	}

	@Override
	public boolean delete(LigneDeCommande t) {
		lcRepo.delete(lcRepo.findOne(t.getId()));
		return true;
	}

	@Override public List<LigneDeCommande> findByFicheCommande_Id( Long id ) {
		return lcRepo.findByFicheCommande_Id( id );
	}

	@Override public Produit findByLigneDeCommande( Long id ) {
		return lcRepo.findByLigneDeCommande( id );
	}
}
