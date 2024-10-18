/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lv.wofe;

/**
 *
 * @author lazaregrail & victorsimon
 * 
 */
import java.util.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class World {
    
    /*
    public Archer robin = new Archer();
    public Archer guillaumeT = new Archer(robin);
    public Paysan peon = new Paysan();
    public Guerrier aragorn = new Guerrier();
    public Loup warwick = new Loup();
    public Lapin bugs = new Lapin();
    public Lapin bugy = new Lapin();
    public PotionSoin heal = new PotionSoin();
    */
  
    private int[][] map;
    private Joueur joueur;
    private Random genAlé = new Random();
    private Scanner scanner = new Scanner(System.in);
    private int nbrSauvegarde = 0;
    
    // identifiant 
    // configuration des id : 
    private int indiceGuerrier = 100; 
    private int indiceArcher = 200;
    private int indicePaysan = 300;
    private int indiceLoup = 400;
    private int indiceLapin = 500;
    private int indiceEpee = 1100;
    private int indicePotion = 1000;
    private int indiceChampi = 1200;
    private int indiceEpinard = 1300;
    private int indiceNuage = 1400;
    
    
    private HashMap<Integer,ElementDeJeu> dicoPerso = new HashMap<>();
    
    private int taille;
    private int currentTour = 0; 

    /**
     * Constructeur de World avec en paramètre la taille du monde qu'on considère pour l'instant carré
     * @param nb 
     */
    
    public World(int nb){
        
        taille = nb;
        
        Random genAlé = new Random(); 
        
        
//        dicoPerso.put(101,new Guerrier(this));
//        dicoPerso.get(101).setpos(5, 6);
//        map[5][6] = 101;

        
        
        // Creation de la Carte 
        if (taille == 0){
            System.out.println("Merci d'entrer le chemin d'accès à la sauvegarde"); 
            String fileName = scanner.nextLine();
            try {
                chargementPartie(fileName);
            } catch (IOException ex) {
                Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            map = new int[taille][taille];
            
            creerNPaysan(genAlé.nextInt(10)+10);
            /*creerNGuerrier(genAlé.nextInt(10)+10);
            creerNArcher(genAlé.nextInt(10)+10);
            creerNLoup(genAlé.nextInt(10)+10);
            creerNLapin(genAlé.nextInt(10)+10);
            creerNPotion(genAlé.nextInt(10)+10);
            creerNEpee(genAlé.nextInt(10)+10); */
            joueur = new Joueur(this);
            
            creerMondeAlea();
            
        }
    }
    
    /**
     *
     * @return tableauélément
     */
    
    public HashMap<Integer,ElementDeJeu> getdico(){
        return dicoPerso;
    }
    
    public void setmap(int x,int y, int valeur){
        map[x][y] = valeur;
    }
    
    public int getmap(int x,int y){
        return map[x][y];
    }
    
    public int getTour(){
        return currentTour;
    }

    public void setTour(int t){
        currentTour = t;
    }
    
    public int getTaille(){
        return taille;
    }
    
    public void setTaille(int t){
        taille = t;
    }
    
    /**
     * creerMondeAlea permet de modifier l'instance de World de sorte que chaque Protagonistes et Objets soient placés aléatoirement dans le Monde.
     */
    
    public void creerMondeAlea(){
        
        Random genAlé = new Random();
        Set<Integer> list = dicoPerso.keySet();
        for(int ind : list){
            int x=-1;
            int y=-1;
            while (dicoPerso.get(ind).getposX()!= x || dicoPerso.get(ind).getposY()!=y){
                x=genAlé.nextInt(taille);
                y=genAlé.nextInt(taille);
                if (map[x][y] == 0){
                    dicoPerso.get(ind).setpos(x,y);
                    map[x][y] = ind;
                }
            }
        }
    }
    
    public void chargementPartie(String fileName) throws FileNotFoundException, IOException{
        try {
            // chargement 
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(fileName));
            ligne = fichier.readLine();
            while (ligne != null) { // Parcours des Lignes du Fichier
                System.out.println(ligne);
                chargementElement(ligne);
                ligne = fichier.readLine();
                }
            fichier.close();
            }  catch (Exception e) {
                System.out.println("Erreur ChargementPartie :" + e);
        }
    }
     
        
    public void chargementElement(String ligneStat){
        String delimiteur = " ";
        StringTokenizer tokenizer = new StringTokenizer(ligneStat, delimiteur);
        String firstWord = tokenizer.nextToken();
        Joueur joueur = null;
        
        switch (firstWord) {
        case "Largeur":
            int largeur = Integer.parseInt(tokenizer.nextToken());
            setTaille(largeur); // nos cartes sont des carrés
            map = new int[taille][taille];
            break;
        
        case "Hauteur":
            int hauteur = Integer.parseInt(tokenizer.nextToken());
            setTaille(hauteur); // nos cartes sont des carrés
            break;
        
        case "Guerrier":
            String nomPersonnageG = tokenizer.nextToken();
            int ptVieG = Integer.parseInt(tokenizer.nextToken());
            int degAttG = Integer.parseInt(tokenizer.nextToken());
            int ptParadeG = Integer.parseInt(tokenizer.nextToken());
            int pourcentageAttG = Integer.parseInt(tokenizer.nextToken());
            int pourcentageParadeG = Integer.parseInt(tokenizer.nextToken());
            int distAttMaxG = Integer.parseInt(tokenizer.nextToken());
            int posXG = Integer.parseInt(tokenizer.nextToken());
            int posYG = Integer.parseInt(tokenizer.nextToken());
            setmap(posXG,posYG,indiceGuerrier);
            indiceGuerrier ++;
            
            Point2D posG = new Point2D(posXG, posYG);
            // Creation du Guerrier
            Guerrier guerrier = new Guerrier(nomPersonnageG, ptVieG, degAttG, ptParadeG, pourcentageAttG, pourcentageParadeG, distAttMaxG, posG, 0, this, new ArrayList<Utilisable>());
            dicoPerso.put(indiceGuerrier ,guerrier);
            break;
            
        case "Archer":
            String nomPersonnageA = tokenizer.nextToken();
            int ptVieA = Integer.parseInt(tokenizer.nextToken());
            int degAttA = Integer.parseInt(tokenizer.nextToken());
            int ptParadeA = Integer.parseInt(tokenizer.nextToken());
            int pourcentageAttA = Integer.parseInt(tokenizer.nextToken());
            int pourcentageParadeA = Integer.parseInt(tokenizer.nextToken());
            int distAttMaxA = Integer.parseInt(tokenizer.nextToken());
            int posXA = Integer.parseInt(tokenizer.nextToken());
            int posYA = Integer.parseInt(tokenizer.nextToken());
            setmap(posXA,posYA,indiceArcher);
            indiceArcher ++;
            
            Point2D posA = new Point2D(posXA, posYA);
            // Creation de l'Archer
            Archer archer = new Archer(nomPersonnageA, ptVieA, degAttA, ptParadeA, pourcentageAttA, pourcentageParadeA, distAttMaxA, posA, 10, 0, this, new ArrayList<Utilisable>());
            dicoPerso.put(indiceArcher ,archer);
            break;
        
        case "Paysan":
            String nomPersonnageP = tokenizer.nextToken();
            int ptVieP = Integer.parseInt(tokenizer.nextToken());
            int degAttP = Integer.parseInt(tokenizer.nextToken());
            int ptParadeP = Integer.parseInt(tokenizer.nextToken());
            int pourcentageAttP = Integer.parseInt(tokenizer.nextToken());
            int pourcentageParadeP = Integer.parseInt(tokenizer.nextToken());
            int distAttMaxP = Integer.parseInt(tokenizer.nextToken());
            int posXP = Integer.parseInt(tokenizer.nextToken());
            int posYP = Integer.parseInt(tokenizer.nextToken());
            setmap(posXP,posYP,indicePaysan);
            indicePaysan ++;
            
            Point2D posP = new Point2D(posXP, posYP);
            // Creation du Paysan
            Paysan paysan = new Paysan(nomPersonnageP, ptVieP, degAttP, ptParadeP, pourcentageAttP, pourcentageParadeP, distAttMaxP, posP, 0, this, new ArrayList<Utilisable>());
            dicoPerso.put(indicePaysan ,paysan);
            break;
            
        case "Loup":
            int ptVieL = Integer.parseInt(tokenizer.nextToken());
            int degAttL = Integer.parseInt(tokenizer.nextToken());
            int ptParadeL = Integer.parseInt(tokenizer.nextToken());
            int pourcentageAttL = Integer.parseInt(tokenizer.nextToken());
            int pourcentageParadeL = Integer.parseInt(tokenizer.nextToken());
            int posXL = Integer.parseInt(tokenizer.nextToken());
            int posYL = Integer.parseInt(tokenizer.nextToken());
            setmap(posXL,posYL,indiceLoup);
            indiceLoup++;
            
            Point2D posL = new Point2D(posXL, posYL);
            // Creation du Loup
            Loup loup = new Loup(ptVieL, degAttL, ptParadeL, pourcentageAttL, pourcentageParadeL, posL, this, new ArrayList<Utilisable>() );
            dicoPerso.put(indiceLoup ,loup);
            break;
        
        case "Lapin":
            int ptVieLa = Integer.parseInt(tokenizer.nextToken());
            int degAttLa = Integer.parseInt(tokenizer.nextToken());
            int ptParadeLa = Integer.parseInt(tokenizer.nextToken());
            int pourcentageAttLa = Integer.parseInt(tokenizer.nextToken());
            int pourcentageParadeLa = Integer.parseInt(tokenizer.nextToken());
            int posXLa = Integer.parseInt(tokenizer.nextToken());
            int posYLa = Integer.parseInt(tokenizer.nextToken());
            setmap(posXLa,posYLa,indiceLapin);
            indiceLapin ++;
            
            Point2D posLa = new Point2D(posXLa, posYLa);
            // Creation du Loup
            Lapin lapin = new Lapin(ptVieLa, degAttLa, ptParadeLa, pourcentageAttLa, pourcentageParadeLa, posLa, this, new ArrayList<Utilisable>() );
            dicoPerso.put(indiceLapin ,lapin);
            break;

        case "PotionSoin":
            int soin = Integer.parseInt(tokenizer.nextToken());
            int posXPot = Integer.parseInt(tokenizer.nextToken());;
            int posYPot = Integer.parseInt(tokenizer.nextToken());;
            setmap(posXPot,posYPot,indicePotion);
            indicePotion ++;
            
            Point2D posPot = new Point2D(posXPot, posYPot);
            // Creation de la Potion
            PotionSoin potionSoin = new PotionSoin(soin, 1, soin%100 ,posPot, this);
            dicoPerso.put(indicePotion ,potionSoin);
            break;
        
        case "Epee": 
            int degEpee = Integer.parseInt(tokenizer.nextToken());
            int posXE = Integer.parseInt(tokenizer.nextToken());
            int posYE = Integer.parseInt(tokenizer.nextToken());
            setmap(posXE,posYE,indiceEpee);
            indiceEpee ++;
          
            Point2D posE = new Point2D(posXE, posYE);
            // Creation de l'Epee
            Epee epee = new Epee(1, degEpee, 3, degEpee*3, posE,this);
            dicoPerso.put(indiceEpee ,epee );
            break;
           
        case "Champignon": 
            int malusPageAtt = Integer.parseInt(tokenizer.nextToken());
            int posXC = Integer.parseInt(tokenizer.nextToken());
            int posYC = Integer.parseInt(tokenizer.nextToken());
            setmap(posXC,posYC,indiceChampi);
            indiceChampi ++;
          
            Point2D posC = new Point2D(posXC, posYC);
            // Creation du Champignon
            Champignon champi = new Champignon(malusPageAtt, posC, this);
            dicoPerso.put(indiceChampi ,champi);
            break;
            
        case "Epinard": 
            int bonusDegAtt = Integer.parseInt(tokenizer.nextToken());
            int posXEpi = Integer.parseInt(tokenizer.nextToken());
            int posYEpi = Integer.parseInt(tokenizer.nextToken());
            setmap(posXEpi,posYEpi,indiceEpinard);
            indiceEpinard ++;
          
            Point2D posEpi = new Point2D(posXEpi, posYEpi);
            // Creation du Champignon
            Epinard epinard = new Epinard(bonusDegAtt, posEpi, this);
            dicoPerso.put(indiceEpinard ,epinard);
            break;
        
        case "NuageToxique": 
            int degAtt = Integer.parseInt(tokenizer.nextToken());
            int vitesse = Integer.parseInt(tokenizer.nextToken());
            int posXN = Integer.parseInt(tokenizer.nextToken());
            int posYN= Integer.parseInt(tokenizer.nextToken());
            setmap(posXN,posYN,indiceNuage);
            indiceNuage ++;
            
            Point2D posN = new Point2D(posXN, posYN);
            // Creation du Champignon
            NuageToxique nuage = new NuageToxique(degAtt, vitesse, posN, this);
            break;


        case "Joueur":
            String role = tokenizer.nextToken();
            String nomPersonnageJ = tokenizer.nextToken();
            int ptVieJ = Integer.parseInt(tokenizer.nextToken());
            int degAttJ = Integer.parseInt(tokenizer.nextToken());
            int ptParadeJ = Integer.parseInt(tokenizer.nextToken());
            int pourcentageAttJ = Integer.parseInt(tokenizer.nextToken());
            int pourcentageParadeJ = Integer.parseInt(tokenizer.nextToken());
            int distAttMaxJ = Integer.parseInt(tokenizer.nextToken());
            int posXJ = Integer.parseInt(tokenizer.nextToken());
            int posYJ = Integer.parseInt(tokenizer.nextToken());
            
            Point2D posJ = new Point2D(posXJ, posYJ);
            // Creation du Joueur
            Personnage roleJ;
            if (role.equals("Guerrier")) {
                roleJ = new Guerrier(nomPersonnageJ, ptVieJ, degAttJ, ptParadeJ, pourcentageAttJ, pourcentageParadeJ, distAttMaxJ, posJ, 0, this, new ArrayList<Utilisable>());
            } else{
                roleJ = new Archer(nomPersonnageJ, ptVieJ, degAttJ, ptParadeJ, pourcentageAttJ, pourcentageParadeJ, distAttMaxJ, posJ, 10, 0, this, new ArrayList<Utilisable>());
            }
            
            joueur = new Joueur(roleJ, 0, new Scanner(System.in), this, 0, new ArrayList<Utilisable>(), new ArrayList<Integer>());
            
            break;

        case "Inventaire": // Inventaire sauvegardé de la forme : Inventaire Objet ID StatObjets 
            String objet = tokenizer.nextToken();
            int ind = Integer.parseInt(tokenizer.nextToken());
            int statObjet = Integer.parseInt(tokenizer.nextToken());
            
            // Creation de l'Objet 
            switch (objet) {
            case "Champignon": 
                int malusPageAttinv = Integer.parseInt(tokenizer.nextToken());
                int posXCinv = Integer.parseInt(tokenizer.nextToken());
                int posYCinv = Integer.parseInt(tokenizer.nextToken());
                
                indiceChampi ++;

                Point2D posCinv = null;
                // Creation du Champignon
                Champignon champiInv = new Champignon(malusPageAttinv, posCinv, this);
                // Ajout à l'inventaire 
                joueur.addInventory(champiInv,ind);
                break;
            
            case "Epinard": 
                int bonusDegAttinv = Integer.parseInt(tokenizer.nextToken());
                int posXEpiinv = Integer.parseInt(tokenizer.nextToken());
                int posYEpiinv = Integer.parseInt(tokenizer.nextToken());
                
                indiceEpinard++;

                Point2D posEpiinv = new Point2D(posXEpiinv, posYEpiinv);
                // Creation du Champignon
                Epinard epinardinv = new Epinard(bonusDegAttinv, posEpiinv, this);
                // Ajout à l'inventaire 
                joueur.addInventory(epinardinv,ind);
                break;
                
            case "PotionSoin":
                int soininv = Integer.parseInt(tokenizer.nextToken());
                int posXPotinv = Integer.parseInt(tokenizer.nextToken());;
                int posYPotinv = Integer.parseInt(tokenizer.nextToken());;

                indicePotion ++;
                
                Point2D posPotinv = new Point2D(posXPotinv, posYPotinv);
                // Creation de la Potion
                PotionSoin potionSoininv = new PotionSoin(soininv, 1, soininv%100 ,posPotinv, this);
                // Ajout à l'inventaire 
                joueur.addInventory(potionSoininv,ind);
                break;
        
            case "Epee": 
                int degEpeeinv = Integer.parseInt(tokenizer.nextToken());
                int posXEinv = Integer.parseInt(tokenizer.nextToken());
                int posYEinv = Integer.parseInt(tokenizer.nextToken());

                indiceEpee ++;
                
                Point2D posEinv = new Point2D(posXEinv, posYEinv);
                // Creation de l'Epee
                Epee epeeinv = new Epee(1, degEpeeinv, 3, degEpeeinv*3, posEinv,this);
                // Ajout à l'inventaire 
                joueur.addInventory(epeeinv,ind);
                break;
            
            default:
                break;
            }
        
        default:
            break;
        }
    }
    
    
    public void sauvegarderPartie(String nomSauvegarde) throws IllegalArgumentException, IllegalAccessException, IOException{
        BufferedWriter bufferedWriter = null;
        try {
            // Creation du BufferedWriter
            bufferedWriter = new BufferedWriter(new FileWriter(nomSauvegarde));
            // Sauvegarde
            
            // Largeur puis Hauteur
            bufferedWriter.write("Largeur " + this.taille);
            bufferedWriter.newLine();
            
            bufferedWriter.write("Hauteur " + this.taille);
            bufferedWriter.newLine();
            
            // les Entites
            
            Set<Integer> list = dicoPerso.keySet();
            for (Integer id: list) {
                // Obtenir la classe de l'objet
                ElementDeJeu e = dicoPerso.get(id);
                String className = e.getClass().getSimpleName();
                String elm = className + " ";
                if(e instanceof Personnage){
                   Personnage p = (Personnage) e;
                   elm = elm + p.getNom() + " " + p.getptVie() + " " + p.getdegAtt() + " " + p.getptPar() + " " + p.getpageAtt() + " " + p.getpagePar() + " " + p.getdistM() + " " + p.getposX() + " " + p.getposY();
                   }
                else if (e instanceof Monstre){
                    Monstre m = (Monstre) e;
                    elm = elm + m.getptVie() + " " + m.getdegAtt() + " " + m.getptPar() + " " + m.getpageAtt() + " " + m.getpagePar() + " " + m.getposX() + " " + m.getposY();
                }
                else if (e instanceof Objet) {
                    Objet o = (Objet) e;
                    String nomClasse = e.getClass().getSimpleName();
                    switch(nomClasse){
                        case "Epee":
                            elm = elm + " " + ((Epee)e).getdegAtt();
                            break;
                        case "Epinard":
                            elm = elm + " " + ((Epinard)e).getBonus();
                            break;
                        case "Champignon":
                            elm = elm + " " + ((Champignon)e).getMalus();
                            break;
                        case "Potion":
                            elm = elm + " " + ((PotionSoin)e).getnbPVRendu();
                            break;
                        default:
                            break;
                    }
                    elm = elm + " " + e.getposX() + " " + e.getposY();
                }
                // Écriture de la ligne dans le fichier
                bufferedWriter.write(elm.toString()); 
                bufferedWriter.newLine();  // Passe à la ligne suivante dans le fichier
            }
            
            // l'Inventaire
            ArrayList<Utilisable> inventaire = joueur.getInventory();
            for (Utilisable item: inventaire){
                Class<?> classeItem = item.getClass();
                
                // Parcourir les attributs de l'objet
                String elmItem =  classeItem + "";
                Field[] champsItem = classeItem.getDeclaredFields();
                for (Field champ : champsItem){
                    champ.setAccessible(true);
                    elmItem = elmItem + champ.get(elmItem)+ ""; 

                bufferedWriter.write(elmItem);
                bufferedWriter.newLine();
                    } 
                }
            }
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        // on ferme le fichier
        finally {
            try {
                if (bufferedWriter != null) {
                    // je force l'écriture dans le fichier
                    bufferedWriter.flush();
                    // puis je le ferme
                    bufferedWriter.close();
                }
            } 
            // on attrape l'exception potentielle
            catch (IOException ex) {
                ex.printStackTrace();
                }
            }
        System.out.println("Sauvegarde Terminée, le Tour reprend !");
    }
        
    public void sauvegarderPartie() throws IllegalArgumentException, IllegalAccessException, IOException{ // le nom est choisit par défaut
        String nomSauvegarde = "sauvegardePartie"+this.joueur.getRole().getNom()+this.nbrSauvegarde;
        this.nbrSauvegarde ++;
        sauvegarderPartie(nomSauvegarde);
    }
        
    
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
        
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
        
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
        
    /**
     * Cree nbGuerrier Guerriers
     * @param nbGuerrier 
     */
    
    public void creerNGuerrier(int nbGuerrier){
        for (int i=0 ; i<nbGuerrier ; i=i+1){
            int indice = 100 + i;
            int ptVie = genAlé.nextInt(21)+190;
            int DA = genAlé.nextInt(11)+55;
            int ptPar = genAlé.nextInt(11)+30;
            int paAtt = genAlé.nextInt(11)+90;
            int paPar = genAlé.nextInt(11)+45;
            int dMax = 1;
            Point2D pos = new Point2D(0,0);
            int argent = genAlé.nextInt(501);
            int nbMain = 0;
            int degEpee = 0;
            int prix = 0;
            int place = 0;
            dicoPerso.put(indice,new Guerrier("guerrier",ptVie,DA,ptPar,paAtt,paPar,dMax,pos,place,nbMain,degEpee,prix,argent,this, new ArrayList<Utilisable>()));
        }
    }
    
    /**
     * Cree nbPaysan Paysans
     * @param nbArcher 
     */
    
    public void creerNArcher(int nbArcher){
        for (int i=0 ; i<nbArcher ; i=i+1){
            int indice = 200 + i;
            int ptVie = genAlé.nextInt(21)+90;
            int DA = genAlé.nextInt(11)+25;
            int ptPar = genAlé.nextInt(10)+1;
            int paAtt = genAlé.nextInt(11)+75;
            int paPar = genAlé.nextInt(11)+15;
            int dMax = genAlé.nextInt(1)+5;
            Point2D pos = new Point2D(0,0);
            int nbF = genAlé.nextInt(21)+20;
            int argent = genAlé.nextInt(501);
            dicoPerso.put(indice,new Archer("archer",ptVie,DA,ptPar,paAtt,paPar,dMax,pos,nbF,argent,this,new ArrayList<Utilisable>()));
        }
    }
    
    /**
     * Cree nbArcher Archers
     * @param nbPaysan 
     */
    
    public void creerNPaysan(int nbPaysan){
        for (int i=0 ; i<nbPaysan ; i=i+1){
            int indice = 300 + i;
            Paysan p = new Paysan(this);
            p.setNom("paysan");
            dicoPerso.put(indice,p);
        }
    }
    
    /**
     * Cree nbLoup Loups
     * @param nbLoup 
     */
    
    public void creerNLoup(int nbLoup){
        for (int i=0 ; i<nbLoup ; i=i+1){
            int indice = 400 + i;
            dicoPerso.put(indice,new Loup(this));
        }
    }
    
    /**
     * Cree nbLapin Lapins
     * @param nbLapin 
     */
    
    public void creerNLapin(int nbLapin){
        for (int i=0 ; i<nbLapin ; i=i+1){
            int indice = 500 + i;
            dicoPerso.put(indice,new Lapin(this));
        }
    }
    
    /**
     * Cree nbPotion PotionSoins
     * @param nbPotion 
     */
    
    public void creerNPotion(int nbPotion){
        for (int i=0 ; i<nbPotion ; i=i+1){
            Random genAlé = new Random(); 
            int indice = 1000 + i;
            dicoPerso.put(indice,new PotionSoin(genAlé.nextInt(20)+20,this));
        }
    }
    
    /**
     * Cree nbEpee Epees
     * @param nbEpee 
     */
    
    public void creerNEpee(int nbEpee){
        for (int i=0 ; i<nbEpee ; i=i+1){
            Random genAlé = new Random();
            int indice = 1100 + i;
            dicoPerso.put(indice,new Epee(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    /**
     * crée nbChampi Champignon
     * @param nbChampi 
     */
    
    public void creerNChampi(int nbChampi){
        for (int i=0 ; i<nbChampi ; i=i+1){
            Random genAlé = new Random();
            int indice = 1200 + i;
            dicoPerso.put(indice,new Champignon(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    /**
     * Crée nbEpi Epinard
     * @param nbEpi 
     */
    
    public void creerNEpi(int nbEpi){
        for (int i=0 ; i<nbEpi ; i=i+1){
            Random genAlé = new Random();
            int indice = 1300 + i;
            dicoPerso.put(indice,new Epinard(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    /**
     * Crée nbEpi Epinard
     * @param nbEpi 
     */
    
    public void creerNNuage(int nbNuage){
        for (int i=0 ; i<nbNuage ; i=i+1){
            Random genAlé = new Random();
            int indice = 1400 + i;
            dicoPerso.put(indice,new NuageToxique(genAlé.nextInt(20)+20,this)); 
        }
    }
    
    /**
     * methode que nous allons appelé a chaque début de tour et qui nous permet de faire toutes les actions à chaque tour
     */
    
    public void tourDeJeu() throws IOException{
        System.out.println("Le Tour commence ...");
        System.out.println("C'est au Joueur de jouer !");
        joueur.joue();
        System.out.println("les Actions suivantes sont effectuées : ");    
        System.out.println("Les Personnages réalisent leurs actions ! "); 
        System.out.println("Les Monstres hantent le royaume ! "); 
        Set<Integer> list = dicoPerso.keySet();
        for (Integer id: list){
            ElementDeJeu perso = dicoPerso.get(id);
            if (perso instanceof Creature){
                int x = perso.getposX();
                int y = perso.getposY();
                // les effets se dissipent :
                List<Utilisable> effets = ((Creature)perso).getEffets();
                int index = 0;
                for(Utilisable effet : effets){
                    if (effet.getutilRestantes() == -1) { // l'effet ne s'applique plus à la Creature
                        effets.remove(index);
                        }
                    else {
                        effet.setutilRestantes(effet.getutilRestantes()-1);  // l'effet se dissipe lentement
                        }
                    index ++;
                }
                        
                // la Creature à deux possibilités d'action : se déplacer et attaquer / par défaut il attaque sauf impossibilité.
                Creature c = (Creature)perso;
                ArrayList<Integer> listAttack = new ArrayList<>();
                ArrayList<Point2D> listParc = new ArrayList<>();
                Point2D pos = new Point2D(c.getposX(), c.getposY());
                int distMax = 1;
                if (c instanceof Personnage){
                    distMax = ((Personnage) c).getdistM();
                    }
                if (c instanceof Combattant){ // la Creature est capable de se battre
                    c.range(listAttack, listParc, pos , 0, distMax);
                    Set<Integer> set = new HashSet<>(listAttack);
                    listAttack = new ArrayList<>(set);
                    if (listAttack.size() <= 1){ // il n'y a personne à attaquer, la Creature se déplace
                        c.deplace();
                    }
                    else { // l'ElementDeJeu attaque un ennemi proche aléatoirement
                        Random genAlé = new Random(); 
                        int enemy = genAlé.nextInt(listAttack.size()-1)+1;
                        Creature e = (Creature) dicoPerso.get(listAttack.get(enemy));
                        ((Combattant) c).combattre(e);
                    }
                }
                else { // la Creature n'est pas capable de se battre
                    c.deplace();
                }
                if (c.getposX() != x || c.getposY() != y){
                    setmap(x,y,0);
                    setmap(c.getposX(),c.getposY(),id);
                }
            }  
        }
        System.out.println("Les effets se dissipent ...");  
        System.out.println("Le Tour se termine ...");    
        this.currentTour++; 
    }
    
    /**
     * permet d'afficher le jeu dans la console
     */
    
    public void afficheJeu(){ 
        for (int i = 0;i <  map.length; i++ ) {
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] == 0) {
                    System.out.print("_ ");
                } else if (map[j][i] == 1){
                    System.out.print("1 ");
                } else if (map[j][i] >= 100 && map[j][i] < 200){
                    System.out.print("G ");
                } else if (map[j][i] >= 200 && map[j][i] < 300){
                    System.out.print("A ");
                } else if (map[j][i] >= 300 && map[j][i] < 400){
                    System.out.print("P ");
                } else if (map[j][i] >= 400 && map[j][i] < 500){
                    System.out.print("W ");
                } else if (map[j][i] >= 500 && map[j][i] < 600){
                    System.out.print("L ");
                } else if (map[j][i] >= 1000 && map[j][i] < 1100){
                    System.out.print("P ");
                } else if (map[j][i] >= 1100 && map[j][i] < 1200){
                    System.out.print("S ");
                } else if (map[j][i] >= 1200 && map[j][i] < 1300){
                    System.out.print("C ");
                } else if (map[j][i] >= 1300 && map[j][i] < 1400){
                    System.out.print("E ");
                } else if (map[j][i] >= 1400 && map[j][i] < 1500){
                    System.out.print("N ");
                }
            }
            System.out.println("");
        }  
    }
}
