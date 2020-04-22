import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.tools.ModelIterator;




public class NQueens {

	public static int n;
	public static int count;
	public static int[] pair = new int[2];
	public static ISolver solver;
	public static PrintWriter writer;
	public static ArrayList<String> clauses;


    private static void solve() throws Exception {
		ModelIterator mi = new ModelIterator(solver);
        IProblem problem = mi;
		AccesModele1 a  ;

		count = 1;
        System.out.println("SOLUTIONS");
        while (problem.isSatisfiable()) {
			a = new AccesModele1(problem.model());
			System.out.println("\nSolution " + count++);
			a.demarrer();
			 while(!a.finDeSequence()){
                 System.out.print(a.elementCourant()+" | ");
				a.avancer();
			}
		}
    }
  
    private static void diagonalRL() throws ContradictionException {
    	//Get the diagonals along the top-side down left
    	//4,3,2,1
    	int x=0;
    	for(int i=n; i>0; i--){
	    	int[] diagnol=new int[x+1];
	    	int y=0;
	    	//4,7,10,13.....3,6,9
			for(int j=i; j<=n*(x+1); j+=n+1){
				diagnol[y]=j;
				y++;
			}
			x++;
			addAllClausesForALine(diagnol, true);
    	}
    	int y=n-1;
    	
    	//Get the diagonals from the left side
    	for(int i=n+1; i<n*n; i+=n){
	    	int[] diagnol=new int[y];
	    	x=0;
			for(int j=i; j<n*n; j+=n+1){
				diagnol[x]=j;	
				x++;
			}
			y--;
			addAllClausesForALine(diagnol, true);
    	}
	}
	public static void rows() throws ContradictionException{
		//i is row count
		 
    	for(int i=0; i<n; i++){
			//1 or 2 or 3 or.. n
			 
	    	int[] wholeRow=new int[n];
			for(int j=0;j<n;j++){
				wholeRow[j]=(j+1)+(i*n);
			} 
			addAllClausesForALine(wholeRow, false);
    	}
    }
    public static void columns() throws ContradictionException{
    	//i is column count
    	for(int i=1; i<=n; i++){
	    	//1 or 5 or 9 or.. n
	    	int[] wholeCol=new int[n];
			for(int j=0;j<n;j++){
				wholeCol[j]=(j*n)+i;
			}
			addAllClausesForALine(wholeCol, false);
    	}
    }
    public static void diagonalLR() throws ContradictionException{
    	//Get the diagonals along the top-side down left
    	for(int i=n; i>0; i--){
	    	int[] diagnol=new int[i];
	    	int x=0;
	    	//4,7,10,13.....3,6,9
			for(int j=i; x<i; j+=n-1){
				diagnol[x]=j;	
				x++;
			}
			addAllClausesForALine(diagnol, true);
    	}

    	int y=n-1;
    	//Get the diagonals from the right side
    	for(int i=n*2; i<n*n; i+=n){
	    	int[] diagnol=new int[y];
	    	int x=0;
	    	//4,7,10,13.....3,6,9
			for(int j=i; j<n*n; j+=n-1){
				diagnol[x]=j;
				x++;
			}
			y--;
			addAllClausesForALine(diagnol, true);
    	}
    }
    private static void createClauses() throws Exception{
    	rows();
    	columns();
    	diagonalLR();
    	diagonalRL();
    }

    public static void addAllClausesForALine(int[] x, boolean diagnol) throws ContradictionException{
    	if(x.length==1){
    		//ignore
    	}
    	else{
			//if not a diagnol, add 1 | 2 | 3 | 4, etc
			AccesModele1 a;
    		if(!diagnol){
    			solver.addClause(new VecInt(x));
    			
				String s=new String();
				///
				a = new AccesModele1(x);
				a.demarrer();
				while(!a.finDeSequence()){
					s += a.elementCourant()+" ";
					a.avancer();
				}
				///
    			/* for(int i=0; i<x.length; i++){
    				s+=x[i]+" ";
    			}  */
    			s+="0";
    			clauses.add(s);
    		}
	    	 for(int k=0; k<x.length; k++){
				for(int l=k+1; l<x.length;l++){
					clauses.add("-"+x[k]+" -"+x[l]+" 0");
					pair[0]=x[k] * -1;
					pair[1]=x[l] * -1;
					solver.addClause(new VecInt(pair));
				}
			} 
			/*
			a = new AccesModele1(x);
			AccesModele1 s = new AccesModele1(x);
			a.demarrer();
			while(!a.finDeSequence()){
				s.demarrer();
				s.avancer();//  :) 
				while(!s.finDeSequence()){
					clauses.add("-"+a.elementCourant()+" -"+s.elementCourant()+" 0");
					pair[0]=a.elementCourant() * -1;
					pair[1]=s.elementCourant() * -1;
					solver.addClause(new VecInt(pair));
					s.avancer();

				}
				a.avancer();
			}

			*/
    	}
    }
    public static void writeCNFFile() throws FileNotFoundException, UnsupportedEncodingException{
		writer.println("c ------------------------ Projet Castor l2 info ------------------------");
		writer.println("c Pierre BRUYERE");
		writer.println("c Vinicius MATTEI");
		writer.println("c Ismaila BALDE");
		writer.println("c ------------------------ Projet Castor l2 info ------------------------");

		writer.println("p cnf "+n+" "+clauses.size());

		for(int i=0;i<clauses.size();i++){
			writer.println(clauses.get(i));
		}

		writer.close();
    }


    public static void main(String[] args){
        try{
        	if(args.length==1){
        		n=Integer.parseInt(args[0]);
        	}
        	else{
				Scanner scan=new Scanner(System.in);
				System.out.println("Veuillez saisir sa taille ");
				n=scan.nextInt();
				scan.close();
        	}
	        writer=new PrintWriter(n+"queens.cnf");
	        clauses=new ArrayList<String>();
	        solver = SolverFactory.newDefault();
	    
        	createClauses();
        	writeCNFFile();
			solve();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
