public void adicionar(Object obj) throws ClassNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException{
        String campos = "";
        String interrogacoes = "";
        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        Field listaAtributos[] = cls.getDeclaredFields();
        String valorIncluir = "";
        int valorIncluirInt;
        String tipoDado;
        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);
            
        //    System.out.print(fld.getName());
        //    System.out.print(fld.getType());
           // System.out.println("dados1: "+fld.getName()+" "+fld.get(obj)+" "+fld.getType());
            if (i != 0){
             //   System.out.println("dados1: "+fld.getName()+" "+fld.get(obj)+" "+fld.getType());
            campos = campos + fld.getName()+", ";
            
            tipoDado = fld.getType().toString();
            if (tipoDado.equals("int")){
                interrogacoes = interrogacoes + '"'+fld.get(obj)+'"';
                System.out.println("interrogacoes: "+interrogacoes);
            }
            
           
            
            try{
                valorIncluir =   valorIncluir + (String) fld.get(obj)+" ";
            }catch(ClassCastException e){
               valorIncluir = valorIncluir + (int) fld.get(obj)+" ";
            }
            }
        }
        campos = campos.substring(0, campos.length()-2);
     //   interrogacoes = interrogacoes.substring(0,interrogacoes.length());
        String tabela = cls.getSimpleName();
        String sql = "INSERT INTO "+tabela+" ("+campos+") VALUES ("+interrogacoes+")";
        System.out.println(sql);
        System.out.println("--------------------------");
      //  System.out.println("dados: "+valorIncluir);
        
        
      //   try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
    //        stmt.setString(1, alu.getNome_aluno());

            //Executa o código sql
      //      stmt.execute();
      //  }
      //  System.out.println("Aluno adicionado ao banco!");
        
 
    }