/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author mabel
 */
import Entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    // Insertar un nuevo usuario
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (id_usuario, nombre, apellido, correo, contrasenia, tipo_usuario, estado, mora_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getContrasenia());
            stmt.setString(6, usuario.getTipoUsuario());
            stmt.setString(7, usuario.getEstado());
            stmt.setFloat(8, usuario.getMoraTotal());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener usuario por ID
    public Usuario obtenerUsuarioPorId(String idUsuario) {
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";
        Usuario usuario = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("contrasenia"),
                        rs.getString("tipo_usuario"),
                        rs.getString("estado"),
                        rs.getFloat("mora_total")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("contrasenia"),
                        rs.getString("tipo_usuario"),
                        rs.getString("estado"),
                        rs.getFloat("mora_total")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Actualizar un usuario
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuario SET nombre = ?, apellido = ?, correo = ?, contrasenia = ?, tipo_usuario = ?, estado = ?, mora_total = ? WHERE id_usuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getContrasenia());
            stmt.setString(5, usuario.getTipoUsuario());
            stmt.setString(6, usuario.getEstado());
            stmt.setFloat(7, usuario.getMoraTotal());
            stmt.setString(8, usuario.getIdUsuario());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un usuario
    public boolean eliminarUsuario(String idUsuario) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, idUsuario);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
